class Solution {
    public int maximumWealth(int[][] accounts) {
        int rowSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int cus=0;cus<accounts.length;cus++)
        {
            rowSum=0;
            for(int acc=0;acc<accounts[cus].length;acc++)
            {
                rowSum+=accounts[cus][acc];
            }
            maxSum=Math.max(maxSum,rowSum);
            // if(rowSum>maxSum)
            // {
            //     maxSum=rowSum;
            // }
        }
        return maxSum;
    }
}