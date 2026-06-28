package dynamic_programming.Strings;

import java.util.*;
import utils.Test;

// Author: Ashmit Singh Gogia
class Solution {
    public int helper(String text1, String text2, int i, int j, int[][] dp) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        char c1 = text1.charAt(i), c2 = text2.charAt(j);
        int ans = 0;
        if (c1 == c2) {
            ans = 1 + helper(text1, text2, i + 1, j + 1, dp);
        }
        ans = Math.max(ans, helper(text1, text2, i + 1, j, dp));
        ans = Math.max(ans, helper(text1, text2, i, j + 1, dp));
        return dp[i][j] = ans;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(text1, text2, 0, 0, dp);
    }
}

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solver = new Solution();
        Test.reset();

        // Example 1
        String text1_1 = "abcde";
        String text2_1 = "ace";
        Test.expect(solver.longestCommonSubsequence(text1_1, text2_1), 3);

        // Example 2
        String text1_2 = "abc";
        String text2_2 = "abc";
        Test.expect(solver.longestCommonSubsequence(text1_2, text2_2), 3);

        // Example 3
        String text1_3 = "abc";
        String text2_3 = "def";
        Test.expect(solver.longestCommonSubsequence(text1_3, text2_3), 0);
    }
}