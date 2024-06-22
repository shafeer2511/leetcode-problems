class Solution:
    def permuteUnique(self, nums):
        nums.sort()
        result = []
        temp_list = []
        self.helper(nums, temp_list, result)
        return result
    
    def helper(self, nums, temp_list, result):
        if len(nums) == 0:
            result.append(temp_list)
            
        for i in range(len(nums)):
            if (i+1 < len(nums) and nums[i] != nums[i+1]) or i+1 == len(nums): # to prevent nums[i+1] out of range
                self.helper(nums[:i]+nums[i+1:], temp_list+[nums[i]], result)