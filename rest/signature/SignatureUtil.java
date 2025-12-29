package signature;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import java.util.Base64;

import structs.Env;
import consts.Constants;

/**
 * Signature and HTTP request utility
 */
public class SignatureUtil {

    private static final DateTimeFormatter TIMESTAMP_FORMATTER = 
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneOffset.UTC);

    public static String doSign(String timestamp, String method, String requestPath, 
                                 String body, String secretKey) throws Exception {
        StringBuilder message = new StringBuilder();
        message.append(timestamp).append(method).append(requestPath);
        if (body != null && !body.isEmpty()) {
            message.append(body);
        }
        
        System.out.println("明文: " + message);
        
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        hmacSha256.init(secretKeySpec);
        
        byte[] digest = hmacSha256.doFinal(message.toString().getBytes(StandardCharsets.UTF_8));
        String encoded = Base64.getEncoder().encodeToString(digest);
        
        System.out.println("密文: " + encoded);
        return encoded;
    }

    public static void doHttp(String requestURL, String requestMethod, String requestPath, 
                               String requestBody, Env env) {
        try {
            URL url = new URL(requestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);
            
            String timestamp = TIMESTAMP_FORMATTER.format(Instant.now());
            String sign = doSign(timestamp, requestMethod, requestPath, requestBody, env.getSecretKey());
            
            conn.setRequestProperty("DC-ACCESS-KEY", env.getKey());
            conn.setRequestProperty("DC-ACCESS-SIGN", sign);
            conn.setRequestProperty("DC-ACCESS-TIMESTAMP", timestamp);
            conn.setRequestProperty("DC-ACCESS-PASSPHRASE", env.getPassphrase());
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("X-Client-Ip", "1.1.1.1");
            
            System.out.println("request: " + requestMethod + " " + requestURL);
            
            if ("POST".equals(requestMethod) && requestBody != null && !requestBody.isEmpty()) {
                conn.setDoOutput(true);
                try (OutputStream os = conn.getOutputStream()) {
                    os.write(requestBody.getBytes(StandardCharsets.UTF_8));
                }
            }
            
            int responseCode = conn.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    responseCode >= 200 && responseCode < 300 ? conn.getInputStream() : conn.getErrorStream()));
            
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println("HTTP request error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
