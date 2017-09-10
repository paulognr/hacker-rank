import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Paulo on 2017-09-07.
 */
public class OddNumbers {

    public static void main(String[] args) {
        Arrays.stream(oddNumbers(2, 5)).forEach(n -> {
            System.out.printf("\nArray 1: " + n);
        });

        Arrays.stream(oddNumbers(3, 10)).forEach(n -> {
            System.out.printf("\nArray 2: " + n);
        });
    }

    static int[] oddNumbers(int l, int r) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = l; i <= r; i++){
            if(i % 2 != 0) {
                numbers.add(i);
            }
        }

        return numbers.stream().mapToInt(i -> i).toArray();
    }
}
