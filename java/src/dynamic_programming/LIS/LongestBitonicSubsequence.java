package dynamic_programming.LIS;

import java.util.*;
import utils.Test;

/*

Longest Bitonic Subsequence
Medium
Hints
Given an array arr of n integers,
the task is to find the length of the longest bitonic sequence.
A sequence is considered bitonic if it first increases, then decreases.
The sequence does not have to be contiguous.
*/

class Solution {
    public int helper(int[] arr , int i , int prev , int flag, int[][][] dp){
        if(i == arr.length){
            return 0;
        }
        if(dp[i][prev][flag] != -1){
            return dp[i][prev][flag];
        }
        int notPick = helper(arr , i+1 , prev , flag , dp);
        int pick = 0;
        if(flag == 0){
            if(prev == 0 || arr[prev-1] < arr[i]){
                pick = 1 + helper(arr , i+1 , i+1 , 0, dp); // increase more
            }
            if(prev == 0 || arr[prev-1] < arr[i]){
                pick = Math.max(pick , 1 + helper(arr , i+1 , i+1 , 1 , dp)); // now we want to decrease
            }
        }else{
            if(arr[prev-1] > arr[i]){
                pick = 1 + helper(arr , i+1 , i+1 , flag , dp);
            }
        }
        return dp[i][prev][flag] =  Math.max(pick , notPick);
    }
    public int longestBitonicSubsequence(int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n][n][2];
        for(int[][] twoD: dp){
            for(int[] oneD: twoD){
                Arrays.fill(oneD , -1);
            }
        }
        return helper(arr , 0 , 0, 0 , dp); // arr // index // prev index // flag(0 , 1, 2);
    }
}

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        Solution solver = new Solution();
        Test.reset();

        // Example 1
        int[] arr1 = {5, 1, 4, 2, 3, 6, 8, 7};
        Test.expect(solver.longestBitonicSubsequence(arr1), 6);

        // Example 2
        int[] arr2 = {10, 20, 30, 40, 50, 40, 30, 20};
        Test.expect(solver.longestBitonicSubsequence(arr2), 8);

        // "Your Turn" Quiz Case
        int[] arr3 = {12, 11, 10, 15, 18, 17, 16, 14};
        Test.expect(solver.longestBitonicSubsequence(arr3), 6);
    }
}