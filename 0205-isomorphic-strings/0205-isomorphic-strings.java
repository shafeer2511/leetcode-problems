class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            char a=s.charAt(i);
            char b=t.charAt(i);
            if(!map.containsKey(a))
            {
                if(set.contains(b))
                {
                    return false;
                }
                map.put(a,b);
                set.add(b);
            }
            else{
                if(!map.get(a).equals(b)){
                    return false;
                }
            }
        }
        return true;
    }
}