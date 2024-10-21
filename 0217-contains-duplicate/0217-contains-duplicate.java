class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); // Sort the array first
        for (int i = 0; i < nums.length - 1; i++) {
            // Check if any two adjacent elements are the same
            if (nums[i] == nums[i + 1]) {
                return true; // Return true as soon as a duplicate is found
            }
        }
        return false; // No duplicates found after checking all elements
    }
}