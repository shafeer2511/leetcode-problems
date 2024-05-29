package leetcode-problems;

class integertoroman {

    private static final int[] decimals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static final String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
       StringBuilder builder = new StringBuilder();
       for(int i = 0; i < decimals.length; i++){
            while(num >= decimals[i]){
                num -= decimals[i];
                builder.append(romans[i]);
            }
       }

       return builder.toString();
    }
}
