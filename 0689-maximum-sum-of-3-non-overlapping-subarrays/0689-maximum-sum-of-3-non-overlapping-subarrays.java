class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Best single, double, and triple sequence found so far
        int bestSeq = 0;
        int[] bestTwoSeq = {0, k};
        int[] bestThreeSeq = {0, k, k*2};

        // Sums of each window
        int seqSum = 0;
        for (int i = 0; i < k; i++) {
            seqSum += nums[i];
        }
        int seqTwoSum = 0;
        for (int i = k; i < k * 2; i++) {
            seqTwoSum += nums[i];
        }
        int seqThreeSum = 0;
        for (int i = k * 2; i < k * 3; i++) {
            seqThreeSum += nums[i];
        }

        // Sums of combined best windows
        int bestSeqSum = seqSum;
        int bestTwoSum = seqSum + seqTwoSum;
        int bestThreeSum = seqSum + seqTwoSum + seqThreeSum;

        // Current window positions
        int seqIndex = 1;
        int twoSeqIndex = k + 1;
        int threeSeqIndex = k*2 + 1;
        while (threeSeqIndex <= nums.length - k) {
            // Update the three sliding windows
            seqSum = seqSum - nums[seqIndex - 1] + nums[seqIndex + k - 1];
            seqTwoSum = seqTwoSum - nums[twoSeqIndex - 1] + nums[twoSeqIndex + k - 1];
            seqThreeSum = seqThreeSum - nums[threeSeqIndex - 1] + nums[threeSeqIndex + k - 1];
            
            // Update best single window
            if (seqSum > bestSeqSum) {
                bestSeq = seqIndex;
                bestSeqSum = seqSum;
            }

            // Update best two windows
            if (seqTwoSum + bestSeqSum > bestTwoSum) {
                bestTwoSeq[0] = bestSeq;
                bestTwoSeq[1] = twoSeqIndex;
                bestTwoSum = seqTwoSum + bestSeqSum;
            }

            // Update best three windows
            if (seqThreeSum + bestTwoSum > bestThreeSum) {
                bestThreeSeq[0] = bestTwoSeq[0];
                bestThreeSeq[1] = bestTwoSeq[1];
                bestThreeSeq[2] = threeSeqIndex;
                bestThreeSum = seqThreeSum + bestTwoSum;
            }

            // Update the current positions
            seqIndex += 1;
            twoSeqIndex += 1;
            threeSeqIndex += 1;
        }

        return bestThreeSeq;
    }
}