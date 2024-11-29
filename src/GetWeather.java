import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetWeather {
    public static void main(String[] args) throws IOException, InterruptedException {
        String key = "3ee80feb-137c-4efd-8cfa-cedaf33c0bc6";
        String headerName = "X-Yandex-Weather-Key";
        String headerValue = key;
        HttpClient client = HttpClient.newHttpClient();
        String uri = "https://api.weather.yandex.ru/v2/forecast?lat=59.773002&lon=30.59422";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header(headerName, headerValue)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Pattern pattern = Pattern.compile("\"fact\":\\{.*\"temp\":(-?\\d+\\.?\\d{0,2})");
        System.out.println(pattern.matcher(response.body()));
        Matcher matcher = pattern.matcher(response.body());
        matcher.find();
        int currentTemp = Integer.parseInt(matcher.group(1));
        System.out.println("Текущая температура: " + currentTemp);
    }
}
