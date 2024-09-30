class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) { 
            bucket[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            int num = entry.getKey();
            bucket[freq].add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (!bucket[i].isEmpty()) {
                res.addAll(bucket[i]);
                if (res.size() > k) {
                    break;
                }
            }
        }
        return res.subList(0, k).stream().mapToInt(Integer::intValue).toArray(); 
    }
}
