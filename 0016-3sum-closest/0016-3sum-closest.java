class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closesum=nums[0]+nums[1]+nums[2];
        
        for(int i=0;i<nums.length;i++)
        {
            int left=i+1;
            int right=nums.length-1;
            while(left<right)
            {
                int currsum=nums[i]+nums[left]+nums[right];
               if(Math.abs(currsum-target)<Math.abs(closesum-target))
               {
                closesum=currsum;
               }
               else if(currsum<target)
               {
                left++;
               }
               else if(currsum>target){
                right--;
               }
               else
               {
                return currsum;
               }
            }
        }
        return closesum;
    }
}