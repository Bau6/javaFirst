import java.text.NumberFormat;
import java.text.ParseException;

public class ExceptionLearning {
    public static void main(String[] args) {
        ExceptionFirst();
        ExceptionSecond();
        ExceptionThird();
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
}
