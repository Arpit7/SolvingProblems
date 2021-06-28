package com.company.arpit.recursion;

class Solution {
    int result=0;
    public int rangeSumBST(Tree root, int low, int high) {

        Integer result=0;
        helper(result,root,low, high) ;
        return result;
    }

    public void helper(Integer result,Tree root, int low, int high)
    {
        if(root==null)
            return ;
        helper(result,root.left,low,high);
        if(root.val>=low && root.val<=high)
        {
            result=result+root.val;
        }
        helper(result,root.right,low,high);



    }


}