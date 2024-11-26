import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SumReceipt {
    public static void main(String[] args) throws IOException {
        String sum = getReceipt();
        System.out.println("Цена покупки: " + sum);
        System.out.println("Слов в файле: " + getCountWords());
        System.out.println("Произведение: " + getMul());
        System.out.println("Произведение с сайта: " + getMul2());
//        System.out.println("Числа: " + writeOrder());
        System.out.println("Полиндром? " + arePalindromes());
    }
    public static String getReceipt() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("receipt.txt"));
        double result = 0;

        while (scanner.hasNextLine()) {
            String[] productInfo = scanner.nextLine().split(";");
            System.out.println(productInfo[0]);
            result += Integer.parseInt(productInfo[1]) * Double.parseDouble(productInfo[2]);
            System.out.println(productInfo[1]);
            System.out.println(productInfo[2]);
        }

        return String.format("%.2f", result);
    }

    public static String getCountWords() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("text1.txt"));
        double result = 0;

        while (scanner.hasNextLine()) {
            String[] productInfo = scanner.nextLine().split(" ");
            for (String word : productInfo) { //countWords += words.length;
                result++;
            }
        }

        return String.format("%.0f", result);
    }

    public static String getMul() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("data.txt"));
        double result = 0;
        double countNum = 1;
        double delNum = 0;
        while (scanner.hasNextLine()) {
            String[] countInfo = scanner.nextLine().split(" ");
            if (result == 0){
                delNum = Integer.parseInt(countInfo[0]);
                result++;
            } else {
                for (String cnt : countInfo) {
                    for (int i = 2; i <= delNum; i++) {
                        if ((i % Integer.parseInt(cnt)) == 0) {
                            countNum = countNum * i;
                        }
                    }
                }
            }
        }

        return String.format("%.0f", countNum);
    }

    public static int getMul2() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("data.txt"));

        int limit = Integer.parseInt(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        int[] delimiters = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            delimiters[i] = Integer.parseInt(strings[i]);
        }

        int mul = 1;

        for (int i = 1; i <= limit; i++) {
            for (int delimiter : delimiters) {
                if (i % delimiter == 0) {
                    mul *= i;
                    break;
                }
            }
        }
        return mul;
    }

    public static String writeOrder() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("numbers.txt"));
        int cnt = 1;
        String output = "";
        while (scanner.hasNextLine()) {
            int num = Integer.parseInt(scanner.nextLine());
            if (cnt == num) {
                output += String.format(num + " ");
            }
            cnt++;
        }

        if (output.equals("")) {
            output = "0";
        }

        try (FileWriter writer = new FileWriter("output.txt", false)) {
            writer.write(output.trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return output;
    }

    public static Boolean arePalindromes() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("strings.txt"));
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            string = string.toLowerCase().replace(" ", "");
            if (!string.equals(new StringBuilder(string.toLowerCase()).reverse().toString())) {
                return false;
            }
        }

        return true;
    }
}
