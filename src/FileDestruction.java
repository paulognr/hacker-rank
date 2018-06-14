public class FileDestruction {

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int security = sc.nextInt();
        String before = sc.nextLine();
        String after = sc.nextLine();
    }*/

    public static void main(String[] args) {
        int security = 1;
        String before = "10001110101000001111010100001110";
        String after =  "01110001010111110000101011110001";

        /*int security = 20;
        String before = "0001100011001010";
        String after = "0001000011000100";*/

        System.out.println(verify(security, before, after));
    }

    private static String verify(int security, String before, String after){
        boolean deleted = false;

        if (before.length() == after.length()) {
            if(security % 2 == 0){
                deleted = before.equalsIgnoreCase(after);
            } else {
                deleted = isInverse(before, after);
            }
        }

        return deleted ? "Deletion succeeded" : "Deletion failed";
    }

    private static boolean isInverse(String before, String after) {
        for(int i = 0; i < before.length(); i++){
            if(Character.getNumericValue(before.charAt(i)) == Character.getNumericValue(after.charAt(i))){
                return false;
            }
        }

        return true;
    }
}
