package dynamic_programming.LIS;

import java.lang.reflect.Array;
import java.util.*;
import utils.Test;


/*

1048. Longest String Chain

You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.

 

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
Example 3:

Input: words = ["abcd","dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.


*/

class Solution {
    public boolean compare(String a , String b){
        if(a.length() - b.length() != 1) return false;
        int i = 0 , j = 0;
        while(i < a.length()){
            if(j < b.length() && a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            }else{
                i++;
            }
        }
        return i == a.length() && j == b.length();
    }
    public int helper(String[] words , int i , int prev){
        if(i == words.length) return 0;
        int pick = 0;
        if(prev == -1 || compare(words[i] , words[prev])){
            pick = 1 + helper(words , i+1 , i);
        }
        int notPick = helper(words , i+1 , prev);
        return Math.max(pick , notPick);
    }
    public int longestStrChain(String[] words) {
        // Method one
        // Arrays.sort(words, (a, b) -> a.length() - b.length());
        // return helper(words , 0 , -1);

        // Method 2
        return longestStrChain2(words);
    }

    public int longestStrChain2(String[] words){
        Arrays.sort(words , (a,b) -> Integer.compare(a.length(), b.length()));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(compare(words[i] , words[j])){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        int max = 0;
        for(int i=1; i<n; i++){
            if(dp[max] < dp[i]){
                max = i;
            }
        }
        return dp[max];
    }

}

public class LongestStringChain {
    public static void main(String[] args) {
        Solution solver = new Solution();
        Test.reset();

        // Example 1
        String[] words1 = {"a", "b", "ba", "bca", "bda", "bdca"};
        Test.expect(solver.longestStrChain(words1), 4);

        // Example 2
        String[] words2 = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        Test.expect(solver.longestStrChain(words2), 5);

        // Example 3
        String[] words3 = {"abcd", "dbqca"};
        Test.expect(solver.longestStrChain(words3), 1);
    }
}