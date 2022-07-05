import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {

        System.out.println(letterCasePermutation("a1b2"));
    }

    private static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(s, 0, new StringBuilder(), result);
        return result;
    }

    private static void helper(String s,
                               int index,
                               StringBuilder partial,
                               List<String> result) {

        if (partial.length() == s.length()) {
            result.add(partial.toString());
            return;
        }

        if (partial.length() > s.length()) {
            return;
        }

        char currentChar = s.charAt(index);
        if (Character.isDigit(currentChar)) {
            partial.append(currentChar);
            helper(s, index + 1, partial, result);
            partial.deleteCharAt(partial.length() - 1);
        } else {
            char upperc = Character.toUpperCase(currentChar);
            partial.append(upperc);
            helper(s, index + 1, partial, result);
            partial.deleteCharAt(partial.length() - 1);

            char lowerc = Character.toLowerCase(currentChar);
            partial.append(lowerc);
            helper(s, index + 1, partial, result);
            partial.deleteCharAt(partial.length() - 1);
        }
    }
}
