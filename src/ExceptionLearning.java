import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ExceptionLearning {
    public static void main(String[] args) throws IOException {
        int cnt = 0;
//        ExceptionFirst();
//        ExceptionSecond();
//        ExceptionThird();
//        ExceptionFourth(cnt);
//        ExceptionFifth();
//        ExceptionSix();
        ExceptionSeventh();
    }

    public static void ExceptionFirst() {
        try {

            NumberFormat nf = NumberFormat.getInstance();

//специально создаем ситуацию, которая приведет к исключению
            System.out.println(nf.parse("NOT A NUMBER"));
        }
        catch (ParseException e) {

            System.out.println(e.getMessage());
        }
        System.out.println("Конец программы!");
    }
    public static void ExceptionSecond() {
        String string = "123";
        try
        {
            char chr = string.charAt(10);
        }
        catch(StringIndexOutOfBoundsException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("Конец программы!");
    }
    public static void ExceptionThird() {
        int x = 10;

        try {
            if(x > 5) {
                throw new Exception("Number is greater than 5");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    public static void ExceptionFourth(int cnt) {
        try {
            ExceptionFourthRecursion(cnt);
        } catch (StackOverflowError e) {
            System.err.println("Переполнение стека: " + e.getMessage());
            cnt = 0; // Сброс счетчика
        } finally {
            if (cnt > 0) {
                System.out.printf("Рекурсивных вызовов: %d%n", cnt);
            } else {
                System.out.println("Рекурсия не произошла");
            }
        }
    }
    public static void ExceptionFourthRecursion(int cnt) {
        cnt++;
        ExceptionFourthRecursion(cnt); // Бесконечная рекурсия
    }
    public static void ExceptionFifth() {
        String name = null;
        try {
            System.out.println(name.length()); // Попытка получить длину пустой строки
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    public static void ExceptionSix() {
        int[] array = {1, 2, -1, 5, 3};
        int s = 0;
        for (int i = 0; i < array.length; i++) {
            s += array[i];
        }
        System.out.println(s);
    }
    public static void ExceptionSeventh() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("borodino.txt"), UTF_8);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер строки в диапазоне 1.." + lines.size());
        int n = in.nextInt();
        try {
            System.out.println("Вот предсказание для вас:\n" + lines.get(n));
        }
        catch (Exception e) {
            System.out.println("Вы ввели недопустимый номер..." );
        }
    }
}
