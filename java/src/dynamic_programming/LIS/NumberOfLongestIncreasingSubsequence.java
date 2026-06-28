package dynamic_programming.LIS;

import java.util.*;
import utils.Test;

// Author: Ashmit Singh Gogia
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] ways = new int[n];
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            ways[i] = 1;
            dp[i] = 1;
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<i; j++){
                if(nums[j] < nums[i]){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j] + 1;
                        ways[i] = ways[j];
                    }else if(dp[i] == dp[j]+1){
                        ways[i] += ways[j];
                    }
                }
            }
        }
        int max = 0;
        int ans = 0;
        for(int i=0; i<n; i++){
            if(dp[i] > max){
                max = dp[i];
                ans = ways[i];
            }else if(dp[i] == max){
                ans += ways[i];
            }
        }
        return ans;
    }
}

public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solver = new Solution();
        Test.reset();

        // Example 1
        int[] nums1 = {1, 3, 5, 4, 7};
        Test.expect(solver.findNumberOfLIS(nums1), 2);

        // Example 2
        int[] nums2 = {2, 2, 2, 2, 2};
        Test.expect(solver.findNumberOfLIS(nums2), 5);
    }
}