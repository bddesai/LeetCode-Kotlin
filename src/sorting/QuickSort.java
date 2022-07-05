package sorting;

public class QuickSort {
    public static void main(String[] args) {

        int[] arr = new int[]{5, 9, 4, 6, 5, 3};


        quicksortHoare(arr, 0, arr.length - 1);

        printArray(arr, arr.length);
    }

    static void quicksortLumoto(int arr[], int start, int end) {
        if (start < end) {


            int partitionIndex = partitionLumoto(arr, start, end);

            quicksortLumoto(arr, start, partitionIndex - 1);
            quicksortLumoto(arr, partitionIndex + 1, end);
        }
    }

    static int partitionLumoto(int[] arr, int start, int end) {
        //int pivot = arr[start + (end - start) / 2];
        int pivot = arr[end];

        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                Swap(arr, i, j);
            }
        }
        Swap(arr, i + 1, end);
        return (i + 1);
    }

    static void quicksortHoare(int arr[], int low, int high) {

        if (low < high) {
            int partitionIndex = partitionHoare(arr, low, high);

            quicksortHoare(arr, low, partitionIndex);
            quicksortHoare(arr, partitionIndex + 1, high);
        }
    }

    static int partitionHoare(int arr[], int low, int high) {
        int pivot = arr[low];
        int start = low - 1, end = high + 1;

        while (true) {
            do {
                start++;
            } while (arr[start] < pivot);

            do {
                end--;
            } while (arr[end] > pivot);


            if (start >= end) {
                return end;
            }

            Swap(arr, start, end);
        }
    }


    static void Swap(int[] array,
                     int position1,
                     int position2) {
        // Swaps elements in an array

        // Copy the first position's element
        int temp = array[position1];

        // Assign to the second element
        array[position1] = array[position2];

        // Assign to the first element
        array[position2] = temp;
    }

    static void printArray(int[] arr, int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(" " + arr[i]);
        System.out.println();
    }
}
