package finalexam.task5;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommunicationManager {

    private String endpoint;

    public CommunicationManager(String endpoint) {
        this.endpoint = endpoint;
    }

    public String sendUserMessage(String message) {
        String response = "";
        try {
            // Create the URL object
            URL url = new URL(endpoint);
            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Set the request method to POST
            connection.setRequestMethod("POST");
            // Set the request headers
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            // Create the JSON message
            String jsonInputString = "{\"message\": \"" + message + "\"}";

            // Send the request
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Read the response
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder responseBuilder = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    responseBuilder.append(responseLine.trim());
                }
                response = responseBuilder.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
