import java.util.Arrays;

public class GroupTheNumbers {

    public static void main(String[] args) {
        int[] arr = new int[]{8,4,9,5,2,9,5,7,10};

        int[] group = groupNumbers(arr);
        System.out.println(Arrays.toString(group));
    }


    private static int[] groupNumbers(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            if(arr[start] % 2 == 0){
                start++;
            } else {
                Swap(arr, start, end);
                end--;
            }
        }
        return arr;
    }

    private static void Swap(final int[] arr, final int pos1, final int pos2){
        final int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

}
