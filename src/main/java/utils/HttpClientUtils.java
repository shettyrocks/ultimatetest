package utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;

public class HttpClientUtils {

    private static final HttpClient client = HttpClient.newHttpClient();

    // Method to make a GET request
    public static String sendGetRequest(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body(); // Return the response body
        } else {
            throw new Exception("HTTP GET Request failed with status: " + response.statusCode());
        }
    }

    // Method to make a POST request with JSON data
    public static String sendPostRequest(String url, String jsonData) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonData))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body(); // Return the response body
        } else {
            throw new Exception("HTTP POST Request failed with status: " + response.statusCode());
        }
    }

    // Utility method to get headers from a URL
    public static HttpHeaders getHeaders(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.headers();
    }
}