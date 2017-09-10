import java.util.Arrays;

/**
 * Created by Paulo on 2017-09-07.
 */
public class LeftRotation {

    public static void main(String[] args) {
        int n = 5;
        int k = 4;
        int a[] = new int[]{1,2,3,4,5};

        for(int i = 0; i < k; i++){
            int first = a[0];

            for(int j = 1; j < n; j++){
                a[j - 1] = a[j];
            }

            a[n - 1] = first;
        }

        StringBuilder response = new StringBuilder();
        for(int i = 0; i < n; i++){
            response.append(a[i] + " ");
        }

        System.out.println(response.toString());
    }
}
