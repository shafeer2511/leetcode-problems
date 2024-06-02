class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int max=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            max=Math.max(max,nums[i]);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]+sum<0)
            {
                sum=0;
                continue;
            }
            else
            {
                sum+=nums[i];
                max=Math.max(max,sum);
            }
        }
        return max;
    }
}