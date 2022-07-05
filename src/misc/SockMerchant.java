import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SockMerchant {

    public static void main(String[] args) {

        int n = 3;
        int[] pairs = new int[]{ 10, 20, 30};

        sockMerchant(n , pairs);
    }


    public static void sockMerchant(int n, int[] pairs){

        if(n < 1 || n > 100 || pairs.length == 0)
            return;

        if (n != pairs.length)
            return;

        int count = 0;

        Set<Integer> set = new HashSet<>();

        for(int i=0; i < pairs.length; i++){
            if(set.contains(pairs[i])) {
                count++;
                set.remove(pairs[i]);
            }
            else{
                set.add(pairs[i]);
            }
        }


        System.out.printf("count= " + count);

    }
}
