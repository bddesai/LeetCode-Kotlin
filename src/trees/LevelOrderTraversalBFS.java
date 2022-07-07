package trees;

import java.util.*;

public class LevelOrderTraversalBFS {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left_ptr = new TreeNode(2);
        root.right_ptr = new TreeNode(3);
        root.left_ptr.left_ptr = new TreeNode(4);
        root.left_ptr.right_ptr = new TreeNode(5);
        root.right_ptr.left_ptr = new TreeNode(6);
        root.right_ptr.right_ptr = new TreeNode(7);

        //List<List<Integer>> result = level_order_traversal(root);
        //List<List<Integer>> result = level_order_traversal_zigzag(root);
//        for (List<Integer> itemList : result) {
//            for (Integer item : itemList) {
//                System.out.print(item + " ");
//            }
//            System.out.println("\n");
//        }


        ArrayList<Integer> result = level_order_traversal_rightview(root);
        for (Integer item : result) {
            System.out.print(item + " ");
        }
    }


    static List<List<Integer>> level_order_traversal(TreeNode root) {
        if (root == null)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = q.poll();
                list.add(node.label);

                if (node.left_ptr != null)
                    q.add(node.left_ptr);
                if (node.right_ptr != null)
                    q.add(node.right_ptr);

                size--;
            }

            result.add(list);
        }

        return result;
    }

    private static ArrayList<Integer> level_order_traversal_rightview(TreeNode root) {
        if(root==null) return null;


        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);


        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size ; i++){
                TreeNode node = q.poll();

                if(size == i+1) // only add the element when you reach last index
                    result.add(node.label);

                if (node.left_ptr != null)
                    q.add(node.left_ptr);

                if (node.right_ptr != null)
                    q.add(node.right_ptr);

            }

        }
        return result;
    }


    static List<List<Integer>> level_order_traversal_zigzag(TreeNode root) {
        if (root == null)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        TreeNode node;
        boolean reverseFlag = false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                node = q.poll();
                list.add(node.label);

                if (node.left_ptr != null)
                    q.add(node.left_ptr);
                if (node.right_ptr != null)
                    q.add(node.right_ptr);
            }
            if (reverseFlag) Collections.reverse(list);

            result.add(list);
            reverseFlag = !reverseFlag;
        }
        return result;
    }

    private static class TreeNode {

        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        TreeNode(int _label) {
            label = _label;
        }
    }

}
