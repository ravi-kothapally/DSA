package com.dsa.Trees;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class Invert_Binary_Tree_226 {


  public TreeNode invertTree(TreeNode root) {
    invert(root);
    return root;
  }

  private void invert(TreeNode root) {
    if(root!=null)
    {
      TreeNode t = root.left;
      root.left=root.right;
      root.right=t;
      invert(root.left);
      invert(root.right);
    }
  }

}
