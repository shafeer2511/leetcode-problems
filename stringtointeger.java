package leetcode-problems;

class Solution {
    public int myAtoi(String s) {
        int result = 0, sign = 1, index = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index >= s.length()) return 0;

        char signedness = s.charAt(index);
        if ((signedness == '+') || (signedness == '-')) {
            if (signedness == '-') sign = -1;
            index++;
        }

        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            if (result > (Integer.MAX_VALUE - digit) / 10) 
                return (sign < 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            result = 10 * result + digit;
            index++;
        }

        return result * sign;
    }
}
