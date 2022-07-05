import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,5};
        int[] arr2 = new int[]{2,4,6,0,0,0};

        merger_first_into_second(arr1, arr2);


        System.out.println(Arrays.toString(arr2));
    }

    static void merger_first_into_second(int[] arr1, int[] arr2) {
        /*
         * Write your code here.
         */

        int n = arr1.length;

        int i = n-1;
        int j = n-1;
        int k = 2*n-1;

        while (i>=0 && j>=0){
            if(arr1[i]> arr2[j])
                arr2[k--] = arr1[i--];
            else
                arr2[k--] = arr2[j--];
        }

        while (i>=0)
            arr2[k--] = arr1[i--];


    }
}
