package dynamic_programming.LIS;

import java.util.*;
import utils.Test;

// Author: Ashmit Singh Gogia
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        
        return new ArrayList<>(); // Temporary mock return
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