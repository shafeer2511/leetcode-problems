class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int n:nums)
        {
            int numOfDig=digits(n);
            if(numOfDig%2==0)
            {
                count++;
            }
        }
        return count;
    }
    int digits(int n)
    {
        if(n<0)
        {
            n=n*-1;
        }

        return (int)(Math.log10(n)+1);
    }
}
