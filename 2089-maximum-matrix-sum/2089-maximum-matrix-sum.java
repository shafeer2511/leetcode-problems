class Solution {
    public long maxMatrixSum(int[][] matrix) {
         long ans=0;
         int negcnt=0;
         int small=Integer.MAX_VALUE;
            for(int i=0;i<matrix.length;i++)
            {
                for(int j=0;j<matrix.length;j++)
                {
                    ans+=Math.abs(matrix[i][j]);

                    small=Math.min(small,Math.abs(matrix[i][j]));

                    if(matrix[i][j]<0)
                    {
                        negcnt++;
                    }
                }
            }
            if(negcnt%2==0)
            {
                return ans;
            }
            else
            {
                return (ans-2*small);
            }
    }
}