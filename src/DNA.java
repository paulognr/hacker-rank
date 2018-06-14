import java.util.Arrays;
import java.util.List;

class Result {
    String before;
    String after;
    int length;

    Result(String before, String after, int length){
        this.before = before;
        this.after = after;
        this.length = length;
    }
}

public class DNA {

    public static void main(String[] args) {
        List<Result> list = Arrays.asList(
                new Result("ABA", "A", 2),
                new Result("A", "ABA", 2),
                new Result("A", "A", 0),
                new Result("AB", "A", 1),
                new Result("A", "AB", 1),
                new Result("ABCCBA", "ABCCBA", 0),
                new Result("ABCCCBA", "ABCCBA", 1),
                new Result("ABCCBA", "ABCCCBA", 1),
                new Result("AAAAA", "AGCGAA", 3),
                new Result("GTTTGACACACATT", "GTTTGACCACAT", 4),
                new Result("GTTTGACACACATT", "G", 13),
                new Result("GTTTGACACACATT", "GTTTGACCACATT", 1),
                new Result("GT", "GTTTGACCACATT", 11),
                new Result("GCGTA", "GTTAGTTAGACT", 11),
                new Result("GTTAGTTAGACT", "GCGTA", 4)
        );

        list.forEach(result -> {
            long length = getMinLengthChangeDNA(result.before, result.after);
            System.out.println(length + " == " + result.length + (length == result.length ? "" : " ERRROUUUUUU"));
        });

    }

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String before = sc.next();
        String after = sc.next();

        System.out.println(length(before, after));
    }*/

    private static long getMinLengthChangeDNA (String before, String after){
        if (before.equals(after)) {
            return 0;
        }

        long equals = getEquals(before, after);
        return after.length() > equals ? after.length() - equals : before.length() - equals;
    }

    private static long getEquals(String before, String after){
        long equals = getEqualsFrom0(before, after);
        String beforeReversed = new StringBuilder(before.substring((int)equals, before.length())).reverse().toString();
        String afterReversed = new StringBuilder(after.substring((int)equals, after.length())).reverse().toString();
        return equals + getEqualsFrom0(beforeReversed, afterReversed);
    }

    private static long getEqualsFrom0(String before, String after){
        long equals = 0;
        for (int i = 0; i < before.length(); i++) {
            if (after.length() == i || before.charAt(i) != after.charAt(i)) {
                break;
            }
            equals++;
        }
        return equals;
    }
}
