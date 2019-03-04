Problem use BFS algorithm to traverse a binary tree

// solution:
// 1) traverse from root one level by one level, use a queue to help store the tree nodes for each level
// 2) for each node, offer it's children into queue then poll it out into the result list

import java.util.*;
// 1. define a tree class
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        value = x;
    }
}

public class BfsTraverse {

    public List<Integer> bfsTraverse(TreeNode root){
        // use result to output the traverse result
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        // corner case
        if(root == null){
            return result;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.peek();
            // offer child nodes
            if (curr.left != null){
                queue.offer(curr.left);
            }
            if (curr.right != null){
                queue.offer(curr.right);
            }
            // poll curr node
            queue.poll();
            result.add(curr.value);
        }
        return result;
    }

    public static void main(String[] args){
        // generate a tree
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
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;

        BfsTraverse traverse = new BfsTraverse();
        List<Integer> result = traverse.bfsTraverse(node1);
        for(int i:result){
            System.out.print(i + " ");
        }
    }
}
