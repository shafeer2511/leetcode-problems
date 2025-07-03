class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character,Integer> map=new HashMap<>();
        // HashMap<Character,Integer> map2=new HashMap<>();
        for(char ch:word1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:word2.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)-1);
        }

        for(int i:map.values())
        {
            if(Math.abs(i)>3){
                return false;
            }
           
        }
        return true;
    }
}