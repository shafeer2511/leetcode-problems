class Solution {
    public boolean isNumber(String s) 
    {
        try{
             if(s.equals("inf")|| s.equals("-inf") || s.equals("+inf")|| s.startsWith("+I") || s.startsWith("-I") || s.startsWith("I") )
            {
                return false;
            }
            if(s.endsWith("f") || s.endsWith("D") )
            {
                return false;
            }
           
            Double.parseDouble(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}