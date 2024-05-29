class Solution {
    public int jump(int[] nums) {
        int jumps=0, curend=0,curfarthest=0;
        for(int i=0;i<nums.length-1;i++)
        {
            curfarthest=Math.max(curfarthest,i+nums[i]);
            if(i==curend)
            {
                jumps++;
                curend=curfarthest;
                if(curend>=nums.length-1)
                {
                    break;
                }
            }
        }
        return jumps;
    }
}

/*Explanation with the Example Input nums = [2, 3, 1, 1, 4]
Initialization:

jumps = 0: This variable keeps track of the number of jumps made.
curEnd = 0: This marks the end of the range that we can reach with the current number of jumps.
curFarthest = 0: This keeps track of the farthest index that we can reach from the current index.
Loop through the array:

The loop runs from the start of the array to the second-to-last element (i < A.length - 1). We don't need to consider the last element since if we can reach or surpass it, the problem is solved.
Updating curFarthest:

For each index i, update curFarthest to the maximum of its current value and i + A[i]. This calculates the farthest we can reach from index i.
Checking if we need to jump:

If i reaches curEnd, it means we need to make a jump since we have exhausted the current range:
Increment jumps by 1.
Update curEnd to curFarthest.
Check if curEnd is greater than or equal to the last index of the array (A.length - 1). If so, break out of the loop since we've found the minimum number of jumps required.
Example Walkthrough with nums = [2, 3, 1, 1, 4]
Initialization:

jumps = 0, curEnd = 0, curFarthest = 0
Iteration 0 (i = 0):

curFarthest = Math.max(0, 0 + 2) = 2
Since i == curEnd (0 == 0):
Increment jumps to 1.
Update curEnd to 2.
Continue to the next iteration.
Iteration 1 (i = 1):

curFarthest = Math.max(2, 1 + 3) = 4
Since i == curEnd (1 == 2) is false, continue to the next iteration.
Iteration 2 (i = 2):

curFarthest = Math.max(4, 2 + 1) = 4
Since i == curEnd (2 == 2):
Increment jumps to 2.
Update curEnd to 4.
Check if curEnd >= A.length - 1 (4 >= 4). It is true, so break out of the loop.
Conclusion
The function returns jumps = 2, which means the minimum number of jumps to reach the last index is 2. This matches the explanation where the minimum number of jumps to reach the last index is 2 (jump 1 step from index 0 to 1, then 3 steps to the last index).

The key idea is to use a greedy approach, always extending the farthest range we can reach and counting jumps whenever we exhaust the current range. This ensures we find the minimum number of jumps needed. */