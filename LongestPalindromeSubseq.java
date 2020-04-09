/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 516. Longest Palindromic
 * Subsequence Given a string s, find the longest palindromic subsequence's length in s. You may
 * assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input:
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 *
 * Example 2:
 * Input:
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
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
        } else if (cost[i - 1][j] >= cost[i][j - 1]) {
          cost[i][j] = cost[i - 1][j];
        } else {
          cost[i][j] = cost[i][j - 1];
        }
      }
    }
    return cost[l][l];
  }
}

public class LongestPalindromeSubseq {

  public static String stringToString(String input) {
    return JsonArray.readFrom("[" + input + "]").get(0).asString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      String s = stringToString(line);

      int ret = new Solution().longestPalindromeSubseq(s);

      String out = String.valueOf(ret);

      System.out.print(out);
    }
  }
}