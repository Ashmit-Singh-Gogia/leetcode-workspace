package dynamic_programming.LIS;

import java.util.*;
import utils.Test;


/*

Largest Divisible Subset

Given an array nums of positive integers, the task is to find the largest subset such that every pair (a, b) of elements in the subset satisfies a % b == 0 or b % a == 0.

Return the subset in any order. If there are multiple solutions, return any one of them.

Note: As there can be multiple correct answers, the compiler returns 1 if the answer is valid, else 0.

*/
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
            hash[i] = i;
        }
        Arrays.sort(nums);
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        hash[i] = j;
                    }
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            if(dp[i] > dp[max]){
                max = i;
            }
        }
        while(max != hash[max]){
            ans.add(nums[max]);
            max = hash[max];
        }
        ans.add(nums[max]);
        Collections.reverse(ans);

        return ans; // Temporary mock return
    }
}

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solver = new Solution();
        Test.reset();

        // Example 1
        int[] nums1 = {3, 5, 10, 20};
        List<Integer> expected1 = Arrays.asList(5, 10, 20);
        Test.expect(solver.largestDivisibleSubset(nums1), expected1);

        // Example 2
        int[] nums2 = {16, 8, 2, 4, 32};
        List<Integer> expected2 = Arrays.asList(2, 4, 8, 16, 32);
        Test.expect(solver.largestDivisibleSubset(nums2), expected2);
    }
}