import java.util.ArrayList;
import java.util.List;

public class TreePathSum {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left_ptr = new TreeNode(2);
        root.right_ptr = new TreeNode(3);
        root.left_ptr.left_ptr = new TreeNode(4);
        root.left_ptr.right_ptr = new TreeNode(5);
        root.right_ptr.left_ptr = new TreeNode(6);
        root.right_ptr.right_ptr = new TreeNode(7);


//        System.out.println("path exists = " + path_sum(root, 7));
//        System.out.println("path exists = " + path_sum_two(root, 10));


    }

    static List<List<Integer>> all_paths_sum_k(TreeNode root, int k){
        List<List<Integer>> result = new ArrayList<>();

        all_paths_sum_k_helper(root, result, k);
    }

    private static List<List<Integer>> all_paths_sum_k_helper(TreeNode node,
                                                              List<List<Integer>> result,
                                                              int k) {
        if(node==null)



    }

    static List<List<Integer>> all_paths_sum_k(TreeNode root, int k){

    }

    private static Boolean path_sum(TreeNode root, int k) {
        return path_sum_helper(root, k);
    }

    private static Boolean path_sum_helper(TreeNode node, int sum) {
        if (node == null) return false;

        if (node.left_ptr == null && node.right_ptr == null) {
            return sum - node.val == 0;
        }

        return path_sum_helper(node.left_ptr, sum - node.val) ||
                path_sum_helper(node.right_ptr, sum - node.val);
    }

    private static Boolean path_sum_two(TreeNode root, int k) {
        return path_sum_two_helper(root, 0, k);
    }

    private static Boolean path_sum_two_helper(TreeNode node, int sum, int k) {
        if (node == null) return false;



        if (node.left_ptr == null && node.right_ptr == null ) {
            return sum + node.val == k;
        }

        return path_sum_two_helper(node.left_ptr, sum + node.val, k) ||
                path_sum_two_helper(node.right_ptr, sum + node.val, k);
    }

    private static class TreeNode {

        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode(int _val) {
            val = _val;
        }
    }
}
