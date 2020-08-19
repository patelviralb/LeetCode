package palindromic_substrings;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 */
class Solution {

    public int countSubstrings(String s) {
        int stringLength = s.length();
        int count = 0;
        boolean[][] isPalindrome = new boolean[stringLength][stringLength];

        // Resetting matrix
        for (int i = 0; i < stringLength; ++i) {
            for (int j = 0; j < stringLength; ++j) {
                isPalindrome[i][j] = false;
            }
        }

        // String length 1
        for (int i = 0; i < stringLength; ++i) {
            ++count;
            isPalindrome[i][i] = true;
        }

        // String length 2
        for (int i = 0; i < (stringLength - 1); ++i) {
            String currentSubstring = s.substring(i, (i + 2));
            if (currentSubstring.charAt(0) == currentSubstring.charAt(1)) {
                ++count;
                isPalindrome[i][i + 1] = true;
            }
        }

        int end = (stringLength - 1);
        // String length more than 3
        for (int i = 2; i <= end; ++i) {
            for (int j = 0; j < (i - 1); ++j) {
                if (s.charAt(j) == s.charAt(i) && isPalindrome[j + 1][i - 1]) {
                    ++count;
                    isPalindrome[j][i] = true;
                }
            }
        }

        return count;
    }
}
