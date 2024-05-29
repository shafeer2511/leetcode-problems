class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();

        int pos[]=new int[m+n];
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                int mul=(num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int p1=i+j, p2=i+j+1;   
                int sum=mul+pos[p2];

                pos[p1]+=sum/10; // carry
                pos[p2]=sum%10; // current digit
            }
        }

        StringBuilder res=new StringBuilder();
        for(int p : pos)
        {
            if(!(res.length()==0 && p==0))
            {
                res.append(p);
            }
        }
        return res.length()==0 ? "0" : res.toString();
    }
}

/*
 * Let's go through the provided Java code step by step with the input num1 = "123" and num2 = "456". The goal is to understand how the code multiplies these two numbers and returns the product as a string.

Step-by-Step Explanation
Initialization:
java
Copy code
int m = num1.length(), n = num2.length();
int[] pos = new int[m + n];
m and n are the lengths of num1 and num2, respectively. For num1 = "123", m = 3. For num2 = "456", n = 3.
An array pos of size m + n is created to store the intermediate and final results. This size (m + n = 6) is enough to hold the maximum possible number of digits in the product.
Multiplication Process
Nested Loops for Multiplication:
java
Copy code
for(int i = m - 1; i >= 0; i--) {
    for(int j = n - 1; j >= 0; j--) {
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
        int p1 = i + j, p2 = i + j + 1;
        int sum = mul + pos[p2];

        pos[p1] += sum / 10;
        pos[p2] = (sum) % 10;
    }
}
The outer loop iterates over each digit of num1 from right to left (i.e., from least significant to most significant digit).
The inner loop does the same for num2.
For each pair of digits (num1[i], num2[j]), we:
Calculate their product: mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0').
Determine the positions p1 and p2 in the pos array where the result will be stored. p1 is the index for the carry, and p2 is the index for the current digit.
Add the product to the current value at pos[p2] to get sum.
Update pos[p1] with the carry (sum / 10).
Update pos[p2] with the remainder (sum % 10).
Example Walkthrough
For num1 = "123" and num2 = "456":

Iteration Details:

i = 2, j = 2: Multiply 3 * 6 = 18, update pos[4] and pos[5] with 1 (carry) and 8 (current digit), respectively.

pos = [0, 0, 0, 0, 1, 8]
i = 2, j = 1: Multiply 3 * 5 = 15, update pos[3] and pos[4] with 1 (carry) and 6 (current digit), respectively.

pos = [0, 0, 0, 1, 6, 8]
i = 2, j = 0: Multiply 3 * 4 = 12, update pos[2] and pos[3] with 1 (carry) and 3 (current digit), respectively.

pos = [0, 0, 1, 3, 6, 8]
i = 1, j = 2: Multiply 2 * 6 = 12, update pos[3] and pos[4] with 1 (carry) and 8 (current digit), respectively.

pos = [0, 0, 1, 4, 8, 8]
i = 1, j = 1: Multiply 2 * 5 = 10, update pos[2] and pos[3] with 1 (carry) and 4 (current digit), respectively.

pos = [0, 0, 2, 4, 8, 8]
i = 1, j = 0: Multiply 2 * 4 = 8, update pos[1] and pos[2] with 1 (carry) and 0 (current digit), respectively.

pos = [0, 1, 0, 4, 8, 8]
i = 0, j = 2: Multiply 1 * 6 = 6, update pos[2] and pos[3] with 1 (carry) and 0 (current digit), respectively.

pos = [0, 1, 1, 0, 8, 8]
i = 0, j = 1: Multiply 1 * 5 = 5, update pos[1] and pos[2] with 0 (carry) and 6 (current digit), respectively.

pos = [0, 6, 1, 0, 8, 8]
i = 0, j = 0: Multiply 1 * 4 = 4, update pos[0] and pos[1] with 0 (carry) and 0 (current digit), respectively.

pos = [0, 5, 6, 0, 8, 8]
Constructing the Final Result
Construct the Result String:
java
Copy code
StringBuilder sb = new StringBuilder();
for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
return sb.length() == 0 ? "0" : sb.toString();
Create a StringBuilder to build the result string.
Iterate through the pos array and append each digit to the StringBuilder, skipping leading zeros.
If the resulting StringBuilder is empty (which shouldn't happen in this case), return "0".
Otherwise, convert the StringBuilder to a string and return it.
Final Result
For the input num1 = "123" and num2 = "456", the pos array after all calculations is [0, 5, 6, 0, 8, 8]. Ignoring the leading zero, the final result string is "56088", which is the correct product of 123 and 456.
 */