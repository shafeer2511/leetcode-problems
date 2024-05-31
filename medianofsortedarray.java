class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;

        int merged[]=new int[n+m];
        for(int i=0;i<m;i++)
        {
            merged[i]=nums1[i];
        }
        for(int i=0;i<n;i++)
        {
            merged[m+i]=nums2[i];
        }
        Arrays.sort(merged);
        int median=0;
        int len=merged.length;
        if(len%2!=0)
        {
            median=merged[len/2];
            return (double)median;
        }
        else{
            median=merged[len/2] + merged[len/2-1];
            return (double)median/2.0;
        }
    }
}