package com.dsa.Trees;

public class Balanced_Binary_Tree_110 {
  private boolean res=true;
  public boolean isBalanced(TreeNode root) {
    maxDepthBalancetree(root);
    return res;
  }
  public int maxDepthBalancetree(TreeNode root) {
    if(root==null || !res)
      return 0;
    final int i = maxDepthBalancetree(root.left);
    final int i1 = maxDepthBalancetree(root.right);
    if(Math.abs(i-i1)>1) res=false;
    return 1+Math.max(i,i1);
  }

  }
