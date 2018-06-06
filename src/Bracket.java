import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bracket {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("{[()]}");
        list.add("{[(])}");
        list.add("{{[[(())]]}}");
        list.forEach(s -> System.out.println(verify(s)));
    }

    private static final List<String> brackets = Arrays.asList("{", "}", "[", "]", "(", ")");

    private static String verify(String text){
        if ("YES".equals(text) || "NO".equals(text)){
            return text;
        }

        String newText = removePair(text);

        if (newText.trim().isEmpty()){
            return "YES";
        }

        if(newText.equals(text)){
            return "NO";
        }

        return verify(newText);
    }

    private static String removePair(String text){
        for(int i = 0; i < text.length(); i++){
            if (text.length() < i + 2){
                break;
            }

            if (isPair(text.substring(i, i+1), text.substring(i+1, i+2))){
                return text.substring(0, i) + text.substring(i+2, text.length());
            }
        }
        return text;
    }

    private static boolean isPair(String current, String next){
        int cOf = brackets.indexOf(current);
        return cOf % 2 == 0 && brackets.get(cOf + 1).equals(next);
    }
}