package sorting;/*
 * Complete the 'merge_sort' function below.
 *
 * The function accepts an integer array as parameter.
 */

class MergeSort {


    public static void main(String[] args) {

        //int[] arr = new int[]{5, 9, 4, 6, 5, 3};
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 99, 77, 55, 33, 11};

        merge_sort(arr);

        printArray(arr, arr.length);

    }

    private static int[] merge_sort(int[] arr) {
        return mergeSortHelper(
                arr,
                0,
                arr.length - 1);
    }

    private static int[] mergeSortHelper(int[] arr, int start, int end) {
        if (start >= end) return arr;

        int mid = (start + end) / 2;
        mergeSortHelper(arr, start, mid);
        mergeSortHelper(arr, mid + 1, end);

        return merge(arr, start, mid, end);
    }

    private static int[] merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;

        // merge
        int[] aux = new int[end - start + 1];

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            aux[k++] = arr[i++];
        }
        while (j <= end) {
            aux[k++] = arr[j++];
        }

        for (i = start; i <= end; i++) {
            arr[i] = aux[i - start];
        }

        return arr;
    }


    static void printArray(int[] arr, int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(" " + arr[i]);
        System.out.println();
    }

}





