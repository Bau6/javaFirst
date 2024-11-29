//import java.io.File;
//import java.io.IOException;
//import java.util.Date;
//import java.util.Map;
//import java.util.Scanner;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class TestWeather {
//    public static void main(String[] args) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//
//        Map<String, Object> data = mapper.readValue(new File("weather.json"), Map.class);
//
//        Map<String, Object> data = mapper.readValue("{\"now\":1732653554,\"now_dt\":\"2024-11-26T20:39:14.408316Z\"}", Map.class);
//
//        System.out.println(data.get("fast"));
//    }
//}
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestWeather {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode weatherData = mapper.readTree(new File("weather.json"));

            double currentTemp = weatherData.get("fact").get("temp").asDouble();
            System.out.println("Текущая температура: " + currentTemp);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите дату в формате \"ГГГГ-ММ-ДД\": ");
            String dateString = scanner.nextLine();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

            JsonNode forecast = null;
            ArrayNode forecasts = (ArrayNode) weatherData.get("forecasts");
            for (JsonNode forecastItem : forecasts) {
                if (forecastItem.get("date").asText().equals(dateString)) {
                    forecast = forecastItem;
                    break;
                }
            }

            if (forecast == null) {
                System.out.println("Прогноз погоды на эту дату не найден");
                return;
            }

            JsonNode dayShort = forecast.get("parts").get("day_short");
            double dayShortTemp = dayShort.get("temp").asDouble();
            JsonNode nightShort = forecast.get("parts").get("night_short");
            double nightShortTemp = nightShort.get("temp").asDouble();

            double avgTemp = (dayShortTemp + nightShortTemp) / 2;

            System.out.println("Средняя температура суток: " + avgTemp);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
