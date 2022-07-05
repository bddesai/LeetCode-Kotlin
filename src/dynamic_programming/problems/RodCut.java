package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCut {

    public static void main(String[] args) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(3);
            list.add(7);
            list.add(8);
            list.add(10);
            list.add(12);


        System.out.println(get_maximum_profit(list));
    }


    static int get_maximum_profit(List<Integer> prices) {
        Integer[] pricesArr = prices.toArray(new Integer[prices.size()]);

        return rodCut(prices.size(), pricesArr);
    }


    static int rodCut(int L, Integer[] prices) {
        Integer[] table = new Integer[L+1];
        table[0] = 0;

        for(int i=1; i<=L; i++){
            int maxRevenue = Integer.MIN_VALUE;

            for(int cut =0 ; cut <i; cut++){
                int revenue = table[i-cut-1] + prices[cut];
                maxRevenue = Math.max(maxRevenue, revenue);
            }
            table[i] = maxRevenue;
        }

        return table[L];
    }
}
