import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Paulo on 2017-09-07.
 */
public class Ransom {

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        String magazine[] = "give me one grand today night".split(" ");
        String ransom[] = "give one grand today".split(" ");

        System.out.println(response(magazine, ransom));
    }

    private static String response(String[] magazine, String[] ransom) {
        Map<String, Integer> magazineMap = getMap(magazine);

        for (String word : ransom) {
            if (magazineMap.containsKey(word)) {
                Integer value = magazineMap.get(word);
                if (value > 1) {
                    magazineMap.put(word, --value);
                } else {
                    magazineMap.remove(word);
                }
            } else {
                return "No";
            }
        }

        return "Yes";
    }

    private static Map<String, Integer> getMap(String[] text) {
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(text).forEach(key -> {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        });

        return map;
    }
}
