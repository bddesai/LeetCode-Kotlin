public class CheckIfSumPossible {

    public static void main(String[] args) {

        System.out.println(check_if_sum_possible(new long[]{2,4,6,8}, 15));

    }


    static boolean check_if_sum_possible(long[] arr, long k) {

        if (arr.length <= 0) return false;

        if (arr.length == 1) return arr[0] == k;

        //return helper(arr, 0, k);

        return helper2(arr, k, 0, 0);
    }
//
//    private static boolean helper(long[] arr, int index, long sum) {
//
//        if (sum == 0) return true;
//
//        if (arr.length - index == 1) {
//            return arr[index] == sum;
//        }
//
//        return helper(arr, index + 1, sum - arr[index]) ;
//    }

    private static boolean helper2(long[] arr, long k, int index, long sum) {

        if (sum == k) return true;

        if (arr.length - index == 1) {
            return arr[index] == sum;
        }

        return helper2(arr, k, index + 1, sum + arr[index])  ;
    }
}
