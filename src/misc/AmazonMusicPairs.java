import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonMusicPairs {

    public static void main(String[] args) {
        int[] nums1 = { 37, 23, 60 };
        int[] nums2 = { 10, 50, 90, 30 };
        int[] nums3 = { 30, 20, 150, 100, 40 };
        int[] nums4 = { 60, 60, 60 };

        List<Integer> nums1List = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++)
            nums1List.add(i, nums1[i]);

        List<Integer> nums2List = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++)
            nums2List.add(i, nums2[i]);

        List<Integer> nums3List = new ArrayList<>();
        for(int i = 0; i < nums3.length; i++)
            nums3List.add(i, nums3[i]);

        List<Integer> nums4List = new ArrayList<>();
        for(int i = 0; i < nums4.length; i++)
            nums4List.add(i, nums4[i]);



        System.out.println(getSongPairCount(nums1List));
        System.out.println(getSongPairCount(nums2List));
        System.out.println(getSongPairCount(nums3List));
        System.out.println(getSongPairCount(nums4List));
        System.out.println(getSongPairCount(null));
    }

    private static int solve(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int n : nums) {
            n = n%60;
            if(map.containsKey(60 - n == 60 ? 0 : 60 - n))
                res += map.get(60 - n == 60 ? 0 : 60 - n);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return res;
    }

    public static long getSongPairCount(List<Integer> songs) {
        if(songs==null || songs.size()==0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int n : songs) {
            n = n%60;
            if(map.containsKey(60 - n == 60 ? 0 : 60 - n))
                res += map.get(60 - n == 60 ? 0 : 60 - n);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return res;
    }
}
