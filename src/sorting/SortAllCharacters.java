package sorting;

import java.util.ArrayList;
import java.util.List;

public class SortAllCharacters {


    public static void main(String[] args) {

        //char[] charArray  = new char[]{'c', 'd', 'b', 'a', 'z', 'x', 'y', 'p', '#', '%', '$'};
        List<Character> arr = new ArrayList<>();
        arr.add('c');
        arr.add('d');
        arr.add('b');
        arr.add('a');
        arr.add('z');
        arr.add('x');
        arr.add('y');
        arr.add('p');
        arr.add('#');
        arr.add('%');
        arr.add('$');

        System.out.println(sort_array(arr));
    }

    private static List<Character> sort_array(List<Character> arr) {
        int[] frequency = new int[128];

        for(char c: arr){
            frequency[c]++;
        }

        List<Character> result = new ArrayList<>();

        for(int i=0; i<128;i++){
            while(frequency[i]>0){
                frequency[i]--;
                result.add((char)i);
            }
        }

        return result;
    }
}
