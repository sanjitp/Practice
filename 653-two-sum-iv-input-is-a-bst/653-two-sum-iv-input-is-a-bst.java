/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorder(TreeNode root,ArrayList<Integer> res)
    {
        if(root==null)
            return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> res=new ArrayList<>();
          inorder(root,res);
        int end=res.size()-1;
        int i=0;
        while(i<end)
        {
           if(res.get(i)+res.get(end)==k)
               return true;
            if(res.get(i)+res.get(end)>k)
               end--;
            else
                i++;
        }
        return false;
    }
}