class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int left=0;
        int right=skill.length-1;
        long ans = 0;
        long set =skill[left]+skill[right];
        while(left<right)
        {
            long diff=skill[left]+skill[right];
            ans+=skill[left]*skill[right];
            left++;
            right--;
            if(set!=diff)
            {
                return -1;
            }
        }
        return ans;
    }
}