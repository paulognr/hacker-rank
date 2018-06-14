import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result1 {
    String message;
    String fragment;
    String response;

    Result1(String message, String fragment, String response){
        this.message = message;
        this.fragment = fragment;
        this.response = response;
    }
}

public class Submarine {

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.next();
        String fragment = sc.next();

        System.out.println(response(message, fragment));
    }*/

    public static void main(String[] args) {
        List<Result1> list = Arrays.asList(
                new Result1("secretmessage", "boot", "essa"),
                new Result1("treetreetreetree", "wood", "3"),
                new Result1("oranges", "apples", "0"),
                new Result1("archipelago", "submarine", "2")
        );

        list.forEach(result -> {
            String response = getResponse(result.message, result.fragment);
            System.out.println(response + " == " + result.response + (response.equalsIgnoreCase(result.response) ? "" : " ERRROUUUUUU"));
        });
    }

    private static String getResponse(String message, String fragment) {
        String response = null;
        int count = 0;
        for(int i = 0; i < message.length(); i++){
            Map<Character, Character> alphabet = getAlphabet(message, fragment, i);
            if (alphabet.isEmpty()) {
                continue;
            }

            if (response == null) {
                response = getMessage(fragment, alphabet);
            }
            count++;
        }

        return count == 0 || count > 1 ? String.valueOf(count) : response;
    }

    private static String getMessage(String fragment, Map<Character, Character> alphabet){
        StringBuilder response = new StringBuilder();
        for(int i = 0; i < fragment.length(); i++){
            response.append(alphabet.get(fragment.charAt(i)));
        }
        return response.toString();
    }

    private static Map<Character, Character> getAlphabet(String message, String fragment, int indexOfMessage) {
        Map<Character, Character> alphabet = new HashMap<>();
        if(indexOfMessage + fragment.length() <  message.length()){
            for (int i = 0; i < fragment.length(); i++) {
                Character charMessage = message.charAt(indexOfMessage);
                Character charFragment = fragment.charAt(i);
                if (alphabet.containsKey(charFragment) && alphabet.get(charFragment) != charMessage) {
                    alphabet.clear();
                    break;
                } else {
                    alphabet.put(charFragment, charMessage);
                }
                indexOfMessage++;
            }
        }
        return alphabet;
    }
}