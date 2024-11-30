import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    public static void main(String[] args) {
        List< Integer > list = new ArrayList< >();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                list.add(Integer.parseInt(reader.readLine()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (Integer i: list) {
                System.out.println(i);
            }
        }
    }
}
