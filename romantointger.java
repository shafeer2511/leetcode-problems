class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> a=new HashMap<>();
        a.put('I',1);
        a.put('V',5);
        a.put('X',10);
        a.put('L',50);
        a.put('C',100);
        a.put('D',500);
        a.put('M',1000);

        int num=0;
        for(int i=0;i<s.length();i++)
        {
            int cur=a.get(s.charAt(i));
            int next;
            if(i+1<s.length())
            {
                next=a.get(s.charAt(i+1));
            }
            else
            {
                next=0;
            }
            if(cur<next)
            {
                num+=next-cur;
                i++;
            }   
            else{
                num+=cur;
            }

        }
        return num;
    }
}