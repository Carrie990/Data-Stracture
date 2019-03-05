// use recursion to get nodes at each level

import java.util.*;
// * Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

public  class LevelOrderTraversal {
    public List<List<Integer>> levelOrderaTraversal(TreeNode root) {
        int height = height(root);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = height; i >= 1; i--) {
            List<Integer> list = new ArrayList<>();
            levelTraversal(root,i,list);
            result.add(list);
        }

        return result;
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left,right)+1;
    }

    public void levelTraversal(TreeNode root, int level, List<Integer> list){

        if (root == null){
            return;
        }
        if (level == 1) {
            list.add(root.val);
        } else if (level > 1){
            levelTraversal(root.left, level - 1, list);
            levelTraversal(root.right, level - 1, list);
        }
    }
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;

        LevelOrderTraversal traversal = new LevelOrderTraversal();
        List<List<Integer>> res = traversal.levelOrderaTraversal(node1);
        for (List<Integer> list:res) {
            for (int e:list){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
