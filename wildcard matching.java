class Solution {
    public boolean isMatch(String str, String pattern) {
        int s=0,p=0,Startindex=-1,match=0;
        while(s<str.length())
        {
        if(p < pattern.length() &&  (pattern.charAt(p)=='?' || str.charAt(s)==pattern.charAt(p)))
        {
            p++;
            s++;
        }
        else if(p<pattern.length() && pattern.charAt(p)=='*')
        {
            Startindex=p;
            match=s;
            p++;
        }
        else if(Startindex!=-1)
        {
            p=Startindex+1;
            match++;
            s=match;
        }
        else return false;
    }
    while(p<pattern.length() &&  pattern.charAt(p)=='*')
    {
        p++;
    }
    return p==pattern.length();
    }

}