public class UnCheckedException {
//    public static void main(String[] args) {
//        int number1 = 1;
//        int number2 = 0;
//
//        try {
//            if (number2 == 0) {
//                throw new DivisionByZeroException("Нельзя делить на 0");
//            }
//            System.out.println(number1 / number2);
//        } catch (DivisionByZeroException a) {
//            System.out.println("ERROR " + a);
//        } finally {
//            System.out.println("Программа завершила свое действие");
//        }
//    }
public static void main(String[] args) {
    System.out.println("Метод Main успешно запущен");
    method1();
    System.out.println("Метод Main заканчивает свою работу");
}
    static void method1() {
        try {
            System.out.println("Первый метод передает привет!");
            method2();
        }
        catch (ArithmeticException err) {
            System.out.println(err.getMessage());
        }
    }
    static void method2() {
        int x = 10;
        int y = 0;
        double z = x / y;
        System.out.println( z );
        System.out.println("Второй метод");
    }
}
