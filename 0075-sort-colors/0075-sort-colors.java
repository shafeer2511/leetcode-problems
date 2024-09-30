class Solution
{
    public void sortColors(int[] nums) 
    {
        // case 0: swap with the element at the start pointer and increment start and middle
        //case 1: no swapping only increament middle
        //case 2: swap with the end pointer and decrement end 

        //stop when the middle pointer has crossed the end pointer ... impplying that the array is sorted

        int start=0;
        int mid=0;
        int end=nums.length-1;
    while(mid<=end)
    {

        switch(nums[mid])  
        {
            case 0:
            swap(nums,start,mid);
            mid++;
            start++;
            break;

            case 1:
            mid++;
            break;

            case 2:
            swap(nums,mid,end);
            end--;
            break;

        }
    }
    }
    public void swap(int nums[],int a,int b)
    {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}