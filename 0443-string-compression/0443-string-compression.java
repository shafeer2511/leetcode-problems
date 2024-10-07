public class Solution
{
    public int compress(char[] chars)
    {
        int indx=0,indxans=0;
        while(indx<chars.length)
        {
            char curr=chars[indx];
            int count =0;
            while(indx <chars.length && curr==chars[indx])
            {
                indx++;
                count++;
            }
            chars[indxans++]=curr;
            if(count!=1)
            {

            for(char c : Integer.toString(count).toCharArray())
            {
                chars[indxans++]=c;
            }
            }
        }
        return indxans;
    }
}