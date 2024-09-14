class Solution {
    public int longestSubarray(int[] nums) {
        int maxval=Integer.MIN_VALUE;
        for(int num : nums)
        {
            if(num>maxval)
            {
                maxval=num;
            }
        }

        int longest=0;
        int currlen=0;

        for(int num : nums)
        {
            if(num==maxval)
            {
                currlen++;
                longest=Math.max(longest,currlen);
            }
            else{
                currlen=0;
            }
        }
    return longest;
    }
}