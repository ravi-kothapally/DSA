package com.dsa.Trees;
/*
Given the root of a binary tree, return its maximum depth.A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node. Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:Input: root = [1,null,2]
Output: 2
 Constraints:The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */
public class Maximum_Depth_of_Binary_Tree_104 {
  private int maxLength;
  public int maxDepth(TreeNode root) {
    if(root==null) return 0;
    return depth(root,1);
  }

  private int depth(TreeNode root, int i) {
    if(maxLength<i)maxLength=i;
    if(root!=null)
    {
      depth(root.left,i+1);
      depth(root.right,i+1);
    }
    return maxLength;
  }

  public int maxDepth2(TreeNode root) {
    if(root == null) return 0;
    return 1 + Math.max(maxDepth2(root.left), maxDepth(root.right));
  }
}
