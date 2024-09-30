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
    public TreeNode func(int nums[],int start, int end)
    {
        if(start>end)
        {
            return null;
        }
        int mid= start+(end-start)/2;
        TreeNode temp = new TreeNode(nums[mid]);
        temp.left = func(nums,start,mid-1);
        temp.right = func(nums,mid+1,end);
        return temp;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if(n==0)
        {
            return null;
        }
        return func(nums,0,n-1);
    }
}