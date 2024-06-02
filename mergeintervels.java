import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> resList = new ArrayList<>();
        int index = 0;
        while (index < intervals.length) {
            int newStart = intervals[index][0];
            int currEnd = intervals[index][1];
            
            while (index < intervals.length - 1 && currEnd >= intervals[index + 1][0]) {
                currEnd = Math.max(currEnd, intervals[index + 1][1]);
                index++;
            }
            int newEnd = currEnd;
            resList.add(new int[]{newStart, newEnd});
            index++;
        }
        
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        
        return res;
    }

    
}
