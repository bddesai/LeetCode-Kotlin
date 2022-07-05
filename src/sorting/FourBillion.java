package sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourBillion {

    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        list.add((long) 4294967);
        list.add((long) 399999999);
        list.add((long) 12);
        list.add((long) 13);
        list.add((long) 14);

        System.out.println(find_integer(list));
    }

    private static long find_integer(List<Long> arr) {


        Set<Long> set = new HashSet<>();

        for (long num : arr){
            set.add(num);
        }

        for(long i=0; i< Math.pow(2,32); i++){
            if (!set.contains(i)){
                return i;
            }
        }

        return -1;
    }
}
