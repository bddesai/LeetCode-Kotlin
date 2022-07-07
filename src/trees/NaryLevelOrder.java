package trees;

import java.util.*;

public class NaryLevelOrder {


    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);

        Vector<TreeNode> childrenof1 = new Vector<>();
        childrenof1.add(new TreeNode(2));
        childrenof1.add(new TreeNode(3));
        childrenof1.add(new TreeNode(4));
        root.children = childrenof1;

        // -----
        Vector<TreeNode> childrenof2 = new Vector<>();
        childrenof2.add(new TreeNode(5));
        childrenof1.get(0).children = childrenof2;

        // -----
        Vector<TreeNode> childrenof3 = new Vector<>();
        childrenof3.add(new TreeNode(6));
        childrenof3.add(new TreeNode(7));
        childrenof1.get(1).children = childrenof3;

        // -----
        Vector<TreeNode> childrenof4 = new Vector<>();
        childrenof4.add(new TreeNode(8));
        childrenof4.add(new TreeNode(9));
        childrenof4.add(new TreeNode(10));
        childrenof1.get(2).children = childrenof4;


        List<List<Integer>> result = nary_level_order(root);
        for (List<Integer> itemList: result){
            for(Integer item : itemList) {
                System.out.print(item+" ");
            }
            System.out.println("\n");
        }
    }


    public static List<List<Integer>> nary_level_order(TreeNode root){
        if(root==null)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            if(size==0) break;

            List<Integer> list = new ArrayList<>();
            for(int i=size; i>0; i--){
                TreeNode temp = queue.peek();
                list.add(temp.label);
                queue.remove();

                // add all children
                queue.addAll(temp.children);
            }
            result.add(list);
        }
        return  result;
    }



    static class TreeNode
    {
        int label;
        Vector<TreeNode> children = new Vector<TreeNode>(0);
        TreeNode(int _label)
        {
            label = _label;
            children.clear();
        }
    };
}
