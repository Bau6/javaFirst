public class UnCheckedException {
    public static void main(String[] args) {
        int number1 = 1;
        int number2 = 0;

        try {
            if (number2 == 0) {
                throw new DivisionByZeroException("Нельзя делить на 0");
            }
            System.out.println(number1 / number2);
        } catch (DivisionByZeroException a) {
            System.out.println("ERROR " + a);
        } finally {
            System.out.println("Программа завершила свое действие");
        }
    }
}
