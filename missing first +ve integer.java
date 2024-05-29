public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1) 
        // (we can ignore those because if all number are > n then we'll simply return 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        // note: all number in the array are now positive, and on the range 1..n+1
        
        // 2. mark each cell appearing in the array, by converting the index for that number to negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;
            }
            num--; // -1 for zero index based array (so the number 1 will be at pos 0)
            if (nums[num] > 0) { // prevents double negative operations
                nums[num] = -1 * nums[num];
            }
        }
        
        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        
        // 4. no positive numbers were found, which means the array contains all numbers 1..n
        return n + 1;
    }
    }

    /*Let's go through the provided code step-by-step using the example input nums = [7, 8, 9, 11, 12] and see how it determines the smallest missing positive integer, which is 1 in this case.

Step 1: Mark invalid numbers
java
Copy code
for (int i = 0; i < n; i++) {
    if (nums[i] <= 0 || nums[i] > n) {
        nums[i] = n + 1;
    }
}
Explanation:

This loop replaces any number that is less than or equal to 0 or greater than n (the length of the array) with n + 1 (which is 6 in this case).
For the input nums = [7, 8, 9, 11, 12], all numbers are greater than 5 (the length of the array), so they will all be replaced by 6.
Result after Step 1:

nums = [6, 6, 6, 6, 6]
Step 2: Use index marking
java
Copy code
for (int i = 0; i < n; i++) {
    int num = Math.abs(nums[i]);
    if (num > n) {
        continue;
    }
    num--; // -1 for zero index based array (so the number 1 will be at pos 0)
    if (nums[num] > 0) { // prevents double negative operations
        nums[num] = -1 * nums[num];
    }
}
Explanation:

This loop is designed to mark the presence of numbers within the range [1, n] by converting the value at the index corresponding to that number to negative.
Since all values in nums are now 6 (which is greater than 5), the loop does nothing in this case.
Result after Step 2:

nums = [6, 6, 6, 6, 6] (unchanged)
Step 3: Find the first positive number
java
Copy code
for (int i = 0; i < n; i++) {
    if (nums[i] >= 0) {
        return i + 1;
    }
}
Explanation:

This loop looks for the first index i where the value is non-negative. The missing positive integer is i + 1.
In nums = [6, 6, 6, 6, 6], all elements are positive, so it will return 1 on the first iteration.
Result after Step 3:

The loop returns 1.
Step 4: Handle the case where all numbers are present
java
Copy code
return n + 1;
Explanation:

This step is only reached if all indices from 0 to n-1 were negative, meaning all numbers from 1 to n are present in the array.
Since we found a positive number in Step 3, this step is not executed in this example.
Conclusion:

The function correctly identifies that the smallest missing positive integer is 1 for the input nums = [7, 8, 9, 11, 12].
Summary
The provided code efficiently determines that the smallest missing positive integer in the array nums = [7, 8, 9, 11, 12] is 1 by marking invalid numbers, using the array indices to indicate presence of numbers, and then finding the first missing index. The approach works in linear time O(n) and uses constant space O(1).




*/ 

Example 2
/*The code provided is a solution to the problem of finding the first missing positive integer in an array. The solution involves several steps to efficiently find this missing number without using extra space. Let's go through the code step by step using the example input nums = [3, 4, -1, 1]:

Step 1: Mark invalid numbers
java
Copy code
for (int i = 0; i < n; i++) {
    if (nums[i] <= 0 || nums[i] > n) {
        nums[i] = n + 1;
    }
}
Explanation:

This loop marks numbers that are either less than or equal to 0 or greater than n (length of the array) with a special marker n + 1 (which is 5 in this case).
For the example nums = [3, 4, -1, 1] after this step, nums becomes [3, 4, 5, 1].
Reasoning:

Numbers outside the range [1, n] are irrelevant because the smallest missing positive integer must be within the range [1, n + 1].
Step 2: Use index marking
java
Copy code
for (int i = 0; i < n; i++) {
    int num = Math.abs(nums[i]);
    if (num > n) {
        continue;
    }
    num--; // -1 for zero index based array (so the number 1 will be at pos 0)
    if (nums[num] > 0) { // prevents double negative operations
        nums[num] = -1 * nums[num];
    }
}
Explanation:

This loop marks the presence of each number by converting the value at the index corresponding to that number to negative.
For each number num in the array:
If num is greater than n, it is ignored.
Otherwise, convert the number to its corresponding index (by subtracting 1 to match zero-indexing).
If the value at that index is positive, it is made negative to indicate the presence of num.
Example Walkthrough:

For the modified nums = [3, 4, 5, 1]:
For i = 0, num = 3: Convert nums[2] to negative -> nums = [3, 4, -5, 1].
For i = 1, num = 4: Convert nums[3] to negative -> nums = [3, 4, -5, -1].
For i = 2, num = 5: Ignored since num > n.
For i = 3, num = 1: Convert nums[0] to negative -> nums = [-3, 4, -5, -1].
Step 3: Find the first positive number
java
Copy code
for (int i = 0; i < n; i++) {
    if (nums[i] >= 0) {
        return i + 1;
    }
}
Explanation:

This loop finds the first index i where the value is positive, indicating that the number i + 1 is missing.
In the modified nums = [-3, 4, -5, -1]:
The first positive number is at index 1, so the missing positive integer is 1 + 1 = 2.
Step 4: Handle the case where all numbers are present
java
Copy code
return n + 1;
Explanation:

If all indices from 0 to n-1 are negative, it means all numbers from 1 to n are present in the array.
In this case, the smallest missing positive integer is n + 1.
Example Conclusion:

For nums = [-3, 4, -5, -1], the missing number is 2, which matches the expected output.
Summary
The code effectively marks the presence of numbers in the array by using the array itself to record this information. This allows it to find the first missing positive integer in linear time O(n) and constant space O(1), which is very efficient. */