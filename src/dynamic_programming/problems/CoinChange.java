package Dynamic_Programming;

import java.util.Arrays;
import java.util.List;

public class CoinChange {
    public static void main(String[] args) {

        System.out.println(
                number_of_ways(Arrays.asList(1, 2, 3), 3)
        );
    }


    public static int number_of_ways(List<Integer> coins, int amount) {

        Integer[] table = new Integer[amount + 1];


        // base case
        table[0] = 0;
        for (int i = 1; i <= amount; i++) {
            table[i] = Integer.MIN_VALUE;
        }


        for (int i = 1; i <= amount; i++) {
            for (Integer c : coins) {
                if ((i - c) >= 0) {
                    table[i] = Math.max(table[i], table[i - c]);
                }
            }
            table[i]++;
        }

        return table[amount];
    }
}
