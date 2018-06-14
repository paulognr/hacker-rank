import java.util.Scanner;

public class Different {

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long a = 10;
            long b = 12;
            System.out.println(Math.abs(a-b));
        }
    }*/

    public static void main(String[] args) {
        long [][] inputs = {{10, 12}, {71293781758123L, 72784}, {1, 12345677654321L}};

        for(int i = 0; i < 3; i++){
            System.out.println(Math.abs(inputs[i][0] - inputs[i][1]));
        }
    }

}