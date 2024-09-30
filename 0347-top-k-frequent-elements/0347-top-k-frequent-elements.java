class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a bucket array where the index is the frequency
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        // Initialize the bucket array
        for (int i = 0; i <= nums.length; i++) { // Fix: Initialize all buckets, including nums.length
            bucket[i] = new ArrayList<>();
        }

        // Step 3: Populate the bucket with elements based on their frequency
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            int num = entry.getKey();
            bucket[freq].add(num);
        }

        // Step 4: Collect the top k frequent elements from the bucket
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (!bucket[i].isEmpty()) {
                res.addAll(bucket[i]);
                if (res.size() > k) {
                    break;
                }
            }
        }

        // Convert result list to array and return
        return res.subList(0, k).stream().mapToInt(Integer::intValue).toArray();  // Convert to int[]
    }
}
