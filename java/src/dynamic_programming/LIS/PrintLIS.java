package dynamic_programming.LIS;


import java.util.*;
import utils.Test;

/*

Print Longest Increasing Subsequence

Given an array of n integers arr, return the Longest Increasing Subsequence (LIS) that is Index-wise Lexicographically Smallest.

The Longest Increasing Subsequence (LIS) is the longest subsequence where all elements are in strictly increasing order.
A subsequence A1 is Index-wise Lexicographically Smaller than another subsequence A2 if, at the first position where A1 and A2 differ, the element in A1 appears earlier in the array arr than corresponding element in S2.

Your task is to return the LIS that is Index-wise Lexicographically Smallest from the given array.

*/


class Solution {
    public List<Integer> longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        int[] dp = new int[n];
        int[] hash = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
            hash[i] = i;
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        hash[i] = j;
                    }
                }
            }
        }
        
        int max = 0;
        for(int i=1; i<n; i++){
            if(dp[i] > dp[max]){
                max = i;
            }
        }
        while(hash[max] != max){
            ans.add(arr[max]);
            max = hash[max];
        }
        ans.add(arr[max]);
        Collections.reverse(ans);
        return ans;
    }
}

public class PrintLIS {
    public static void main(String[] args) {
        Solution solver = new Solution();
        Test.reset();

        // Example 1
        int[] arr1 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        List<Integer> expected1 = Arrays.asList(10, 22, 33, 50, 60, 80);
        Test.expect(solver.longestIncreasingSubsequence(arr1), expected1);

        // Example 2
        int[] arr2 = {1, 3, 2, 4, 6, 5};
        List<Integer> expected2 = Arrays.asList(1, 3, 4, 6);
        Test.expect(solver.longestIncreasingSubsequence(arr2), expected2);
    }
}