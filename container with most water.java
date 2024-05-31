class Solution {
    public int maxArea(int[] height) {
        if(height.length<2)
        {
            return 0;
        }

        int left=0,right=height.length-1;
        int max=-1;
        while(left<right)
        {
            int width=right-left;
            int minheight=Math.min(height[left],height[right]);
            max=Math.max(max,width*minheight);

            if(height[left]<height[right])
            {
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}