import java.util.Arrays;
import java.util.Collection;

public class ArraysLearn {
    public static void main(String[] args) {
        ArraysLearn1();
    }

    private static void ArraysLearn1() {
        char[] arr = new char[5];
        arr[0] = 'A';
        arr[1] = 'B';
        arr[2] = 'C';
        arr[3] = 'F';
        arr[4] = 'D';

        Arrays.sort(arr);

        Arrays.fill(arr, 'E');

        System.out.println(arr);
    }
}
