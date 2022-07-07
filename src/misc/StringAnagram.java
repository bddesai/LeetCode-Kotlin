package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringAnagram {
    public static void main(String[] args) {

        List<String> dict = Arrays.asList("heater", "cold", "clod", "reheat", "docl");
        List<String> query = Arrays.asList("codl", "heater", "abcd");

        System.out.printf(stringAnagram(dict, query).toString());
    }

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        // Write your code here

        if (dictionary.size() <= 1 ||
                dictionary.size() >= Math.pow(10, 5) ||
                query.size() <= 1 ||
                query.size() >= Math.pow(10, 5)) {
            return null;
        }

        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < query.size(); i++) {

            result.add(i, 0);
            for (int j = 0; j < dictionary.size(); j++) {
                if (isAnagram(query.get(i), dictionary.get(j))) {
                    result.set(i, result.get(i) + 1);
                }
            }
            System.out.println("");
        }

        return result;
    }

    public static boolean isAnagram(String dictString, String queString) {
        if (dictString.length() != queString.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < dictString.length(); i++) {
            table[dictString.charAt(i) - 'a']++;
        }
        for (int i = 0; i < queString.length(); i++) {
            table[queString.charAt(i) - 'a']--;
            if (table[queString.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
