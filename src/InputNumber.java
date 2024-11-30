import java.io.BufferedReader;
import java.io.IOException;
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

    public String input() throws Exception {
        String s = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            s = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (s.equals("")) {
            throw new Exception("String can not be empty!");
        }
        return s;
    }
}
