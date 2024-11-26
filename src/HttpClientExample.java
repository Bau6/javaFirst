import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        main2();
        main3();
    }
    public static void main2() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            System.err.println("Error making HTTP request: " + e.getMessage());
        }
    }
    public static void main3() {
        // Создаем экземпляр HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // Создаем URI для отправки POST запроса
        URI uri = URI.create("https://jsonplaceholder.typicode.com/posts");
        // Создаем тело запроса
        String requestBody = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";
        // Создаем HttpRequest с методом POST и устанавливаем тело запроса
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-Type", "application/json")
                .build();
        // Отправляем POST запрос и получаем ответ
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Выводим статус код и тело ответа
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        } catch (Exception e) {
            System.err.println("Error occurred while sending POST request: " + e.getMessage());
        }
    }
}