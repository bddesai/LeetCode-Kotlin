package sorting;

import java.util.Arrays;

public class MergeOneSortedArrayIntoAnother {


    public static void main(String[] args) {


//        int[] arr1 = new int[]{1, 3, 5};
//        int[] arr2 = new int[]{2, 4, 6, 0, 0, 0};

        int[] arr1 = new int[]{43, 56, 74};
        int[] arr2 = new int[]{14, 61, 82, 0, 0, 0};

        mergeTwoSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(arr2));
    }


    static void mergeTwoSortedArrays(int[] arr1, int[] arr2) {

        int i = arr1.length - 1;
        int j = i;
        int k = arr2.length - 1;

        while (i >= 0 && j >= 0) {
            if (arr1[i] <= arr2[j]) {
                arr2[k--] = arr2[j--];
            } else {
                arr2[k--] = arr1[i--];
            }
        }

        while (i >= 0) {
            arr2[k--] = arr1[i--];
        }
    }
}
