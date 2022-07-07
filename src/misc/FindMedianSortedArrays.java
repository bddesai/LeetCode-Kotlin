package misc;

import java.util.Arrays;

public class FindMedianSortedArrays {

    public static void main(String[] args) {


        int[] nums1 = new int[] {};
        int[] nums2 = new int[] {1};


        System.out.println(Arrays.toString(mergeArrays(nums1, nums2)));

        System.out.println(
                "Median = "+
                findMedianSortedArrays(nums1, nums2)
        );

    }

    public static int[] mergeArrays(int[] nums1, int[] nums2){
        if (nums1==null || nums2==null || nums1.length==0 || nums2.length==0)
            return null;

        int m = nums1.length;
        int n = nums2.length;

        int i =0 , j =0, k=0;
        int[] result= new int[m+n];

        while(i< m && j<n){
            if (nums1[i] > nums2[j]) {
                result[k] =  nums2[j];
                j++;
            } else if (nums1[i] < nums2[j]) {
                result[k] =  nums1[i];
                i++;
            } else {
                result[k] =  nums1[i];
                i++; j++;
            }
            k++;
        }

        // Store remaining elements of first array
        while (i < m)
            result[k++] = nums1[i++];

        // Store remaining elements of second array
        while (j < n)
            result[k++] = nums2[j++];

        return result;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1==null && nums2==null) || (nums1.length==0 && nums2.length==0))
            return 0.0;

        if (nums1.length==0 && nums2.length==1){
            return nums2[0];
        }
        if (nums2.length==0 && nums1.length==1){
            return nums1[0];
        }

        int[] result = mergeArrays(nums1, nums2);

        int total = result.length;

        int medianIdx;
        double median = 0;

        if(total %2!=0)
        {
            medianIdx = total/2;
            median = (double) result[medianIdx];
        } else {
            medianIdx = total / 2;

            median = ((double) result[medianIdx] + (double) result[medianIdx-1])/2;
        }

        return median;
    }
}
