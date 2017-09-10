import java.util.*;

/**
 * Created by Paulo on 2017-09-07.
 */
public class Anagrams {

    public static void main(String[] args) {
        String first = "cde";
        String second = "abc";

        System.out.println(numberNeeded(first, second));
    }

    public static int numberNeeded(String first, String second) {
        Map<String, Integer> firstMap = getMap(first);
        Map<String, Integer> secondMap = getMap(second);

        List<Integer> removed = new ArrayList<>();
        firstMap.keySet().removeIf(key -> {
            boolean contains = !secondMap.keySet().contains(key);
            if(contains){
                removed.add(firstMap.get(key));
            }
            return contains;
        });

        secondMap.keySet().removeIf(key -> {
            boolean contains = !firstMap.keySet().contains(key);
            if(contains){
                removed.add(secondMap.get(key));
            }
            return contains;
        });

        int difference = 0;
        for (String key : firstMap.keySet()) {
            int size = firstMap.get(key) - secondMap.get(key);
            if (size < 0) {
                size = size * -1;
            }
            difference += size;
        }

        return difference + removed.stream().mapToInt(Integer::intValue).sum();
    }

    private static Map<String, Integer> getMap(String text) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            String key = text.substring(i, i + 1);

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        return map;
    }
}
