package longest_palindrome_subsequence;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */
class Solution {

    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int l = s.length();
        int[][] cost = new int[l + 1][l + 1];

        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= l; j++) {
                if (r.charAt(i - 1) == s.charAt(j - 1)) {
                    cost[i][j] = cost[i - 1][j - 1] + 1;
                } else
                    cost[i][j] = Math.max(cost[i - 1][j], cost[i][j - 1]);
            }
        }
        return cost[l][l];
    }
}
