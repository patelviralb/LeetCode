/**
https://leetcode.com/problems/roman-to-integer/
13. Roman to Integer
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3

Example 2:

Input: "IV"
Output: 4

Example 3:

Input: "IX"
Output: 9

Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/
/**
3999 / 3999 test cases passed.
Runtime: 3 ms
Memory Usage: 41.2 MB
*/

class Solution {
    public int romanToInt(String s) {
        return valueOfString(s.toCharArray(), 0, 0);
    }
    
    public int valueOfString(char[] roman, int i, int value) {
        //System.out.println("Enter");
        if (i >= roman.length) {
            return value;
        } else {
            i++;
            switch(roman[i-1]) {
                case 'M':
                    value += 1000;
                    break;
                case 'D':
                    value += 500;
                    break;
                case 'L':
                    value += 50;
                    break;
                case 'V':
                    value += 5;
                    break;
                case 'I':
                    if(i < roman.length && (roman[i] == 'V' || roman[i] == 'X')) {
                        value -= 1;
                    }else {
                        value += 1;
                    }
                    break;
                case 'X':
                    if(i < roman.length && (roman[i] == 'L' || roman[i] == 'C')) {
                        value -= 10;
                    }else {
                        value += 10;
                    }
                    break;
                case 'C':
                    if(i < roman.length && (roman[i] == 'D' || roman[i] == 'M')) {
                        value -= 100;
                    }else {
                        value += 100;
                    }
                    break;
                    
            }
        }
        return valueOfString(roman, i, value);
    }
}

public class RomanToInteger {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().romanToInt(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}