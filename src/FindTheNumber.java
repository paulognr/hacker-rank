import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Paulo on 2017-09-07.
 */
public class FindTheNumber {

    public static void main(String[] args) {
        int[] array1 = new int[7]; // YES
        array1[0] = 5;
        array1[1] = 1;
        array1[2] = 2;
        array1[3] = 3;
        array1[4] = 4;
        array1[5] = 5;
        array1[6] = 1;

        int[] array2 = new int[5]; // NO
        array2[0] = 3;
        array2[1] = 2;
        array2[2] = 3;
        array2[3] = 1;
        array2[4] = 5;

        System.out.printf("Array 1: " + findNumberStrem(Arrays.copyOf(array1, array1.length), 1));

        System.out.printf("Array 1: " + findNumberHashSet(Arrays.copyOf(array1, array1.length), 1));
        //System.out.printf("Array 2: " + findNumberStrem(Arrays.copyOf(array2, array2.length), 4));

        //System.out.printf("Array 2: " + findNumberHashSet(Arrays.copyOf(array2, array2.length), 4));
    }

    static String findNumberStrem(int[] arr, int k) {
        long startTime = System.currentTimeMillis();

        String result = Arrays.stream(arr).filter(n -> n == k).count() > 0 ? "YES" : "NO";

        long endTime   = System.currentTimeMillis();
        System.out.println("\nStrem total time: " + (endTime - startTime));
        return result;
    }

    static String findNumberHashSet(int[] arr, int k) {
        long startTime = System.currentTimeMillis();

        Set<Integer> hash = new HashSet();
        Arrays.stream(arr).forEach(i -> hash.add(i));
        String result = hash.contains(k) ? "YES" : "NO";

        long endTime   = System.currentTimeMillis();
        System.out.println("\nHashSet total time: " + (endTime - startTime));
        return result;
    }
}
