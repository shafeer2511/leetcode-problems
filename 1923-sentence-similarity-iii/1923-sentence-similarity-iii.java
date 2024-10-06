class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        String[] word1=s1.split(" "),word2=s2.split(" ");
        int i=0,n1=word1.length,n2=word2.length;
        if(n1>n2)
        {
            return areSentencesSimilar(s2,s1);
        }
        while(i<n1 && word1[i].equals(word2[i]))
        {
            ++i;
        }
        while(i<n1 && word1[i].equals(word2[n2-n1+i]))
        {
            ++i;
        }
        return i== n1;
    }
}