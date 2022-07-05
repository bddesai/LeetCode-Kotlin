package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static void main(String[] args) {

        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;

        System.out.println("Answer"+Arrays.toString(topKFrequent(nums, k)));

    }

    public static int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // num , freq
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }



        for(int key : map.keySet()){
            int[] temp = new int[2];
            temp[0] = key;
            temp[1] = map.get(key);

            heap.add(temp);

            if (heap.size() > k) {
                int[] smthng = heap.poll();
                System.out.println("smthng="+Arrays.toString(smthng));
            }
        }

        int[] result = new int[heap.size()];

        int i = result.length-1;
        while(!heap.isEmpty()) {
            int[] tmp = heap.poll();
            result[i] = tmp[0];
            i--;
        }

        return result;
    }
}
