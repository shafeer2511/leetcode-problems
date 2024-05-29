class Solution {
    public int trap(int[] height) {
        int left[]=new int[height.length]; //to keep track of the left and right height of the buildings
        int right[]=new int[height.length];
        int max=-1;
        for(int i=0;i<height.length;i++)
        {
            if(height[i]>=max)
            {
                max=height[i];
            }
            left[i]=max;   //stores the height to the building from left to right respectively
        }

        max=-1;
        for(int i=height.length-1;i>=0;i--)
        {
            if(height[i]>=max)
            {
                max=height[i];
            }
            right[i]=max;  // same as th left to right calculation
        }
        int total=0;
        for(int i=0;i<height.length;i++)
        {
            total+=Math.min(left[i],right[i])-height[i];   //find the minimum of the left and right heights of a particular building and decrease it by its heights
        }
        return total;
    }
}