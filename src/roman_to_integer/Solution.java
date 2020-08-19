package roman_to_integer;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
class Solution {
    public int romanToInt(String s) {
        return valueOfString(s.toCharArray(), 0, 0);
    }

    public int valueOfString(char[] roman, int i, int value) {
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
