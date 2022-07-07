package misc;

import java.util.Arrays;

public class KDiffPairs {

    public static void main(String[] args) {
        int[] nums1 = {3,1,4,1,5};
        int k1 = 2;
        System.out.println(findPairs(nums1, k1));

        int[] nums2 = {1,2,3,4,5};
        int k2 = 1;
        System.out.println(findPairs(nums2, k2));
    }

    public static int findPairs(int[] nums, int k) {
        //Input: nums = [3,1,4,1,5], k = 2
        // Output: 2
        // 1,1,3,4,5

        Arrays.sort(nums);
        nums = removeDuplicates(nums);


        int count = 0;
        for(int i = nums.length-1; i>=0; i--){
            for(int j = i-1; j>=0; j--){
                if(nums[i]-nums[j] == k){
                    count++;
                }
            }
        }

        return count;
    }

    public static int[] removeDuplicates(int []s){
        int result[] = new int[s.length], j=0;
        for (int i : s) {
            if(!isExists(result, i))
                result[j++] = i;
        }
        return result;
    }

    private static boolean isExists(int[] array, int value){
        for (int i : array) {
            if(i==value)
                return true;
        }
        return false;
    }
}
