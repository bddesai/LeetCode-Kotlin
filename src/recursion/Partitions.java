package recursion;

import java.util.ArrayList;
import java.util.List;

public class Partitions {


    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        helper(s, 0, new ArrayList<String>(), result, s.length());
        return result;
    }

    public void helper(String s, int index, ArrayList<String> slate, List<List<String>> result, int len) {

        if (index == len) {
            result.add(new ArrayList<String>(slate));
            return;
        }

        for (int i = index; i < len; i++) {

            if (isPalindrome(s, index, i + 1)) {
                //slate.add(s.substring(index, i+1));
                slate.add(s.substring(index, i + 1));
                helper(s, i + 1, slate, result, len);
                slate.remove(slate.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        start = 0;
        end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }
}