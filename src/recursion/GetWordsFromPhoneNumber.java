import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GetWordsFromPhoneNumber {


    private static List<String> combinations = new ArrayList<>();
    private static HashMap<Integer, String> numbersMap = new HashMap<Integer, String>(){{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
    }};

    private static String phoneDigits;

    public static void main(String[] args) {
        //Integer[] arr = getWordsFromPhoneNumber("1234567").toArray();
        System.out.println(Arrays.toString(getWordsFromPhoneNumber("1234").toArray()));


    }

    public static List<String> getWordsFromPhoneNumber(String phoneNumber) {


        if (phoneNumber.length() == 0) {
            return combinations;
        }

        // Initiate backtracking with an empty path and starting index of 0
        phoneDigits = phoneNumber;
        helper( new StringBuilder(), 0);
        return combinations;
    }


    public static void helper(StringBuilder path, int index){

        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return; // Backtrack
        }



        // Get the letters that the current digit maps to, and loop through them
        int number = phoneDigits.charAt(index)-'0';
        System.out.println(number);
        if(number ==1 || number==0){
            index++;
            helper(path, index);
        }
        else {
            String possibleLetters = numbersMap.get(number);
            if (possibleLetters != null) {
                for (char letter : possibleLetters.toCharArray()) {
                    // Add the letter to our current path
                    path.append(letter);
                    // Move on to the next digit
                    helper(path, index + 1);
                    // Backtrack by removing the letter before moving onto the next
                    path.deleteCharAt(path.length() - 1);
                }
            }
        }


    }

}
