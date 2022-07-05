package sorting;

import java.util.Arrays;

public class GroupNumbers {
    public static void main(String[] args) {


        System.out.println(Arrays.toString(solve(new int[]{1,444,33,88,9999, 5, 12, 30, 31, 101})));
    }


    static int[] solve(int[] arr) {

        if(arr==null)
            return null;

        int n = arr.length;
        int e = 0, o = n - 1;


        while(e<=o){
            if(arr[e]%2==0){
                e++;
            } else {
                if(arr[o]%2==0){
                    swap(arr, o, e);
                } else {
                    o--;
                }
            }
        }

        return arr;
    }


    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}



