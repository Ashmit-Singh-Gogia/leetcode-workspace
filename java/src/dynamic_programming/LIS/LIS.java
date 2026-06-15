package dynamic_programming.LIS;
import java.util.*;
import utils.Test;

// Author: Ashmit Singh Gogia
class Solution {
    public void bs(List<Integer> list , int target){
        int s = 0 , e = list.size() - 1;
        int ans = 0;
        while(s <= e){
            int mid = s + (e-s) / 2;
            if(list.get(mid) == target){
                return;
            }else if(list.get(mid) < target){
                s = mid + 1;
            }else{
                ans = mid;
                e = mid - 1;
            }
        }
        list.set(ans , target);
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(list.size() == 0 || list.get(list.size() - 1) < nums[i]){
                list.add(nums[i]);  
            }else{
                bs(list , nums[i]);
            }
        }
        return list.size();
    }
}

public class LIS {
    public static void main(String[] args) {
        Solution solver = new Solution();
        Test.reset();

        int[] nums1 = {10,9,2,5,3,7,101,18};
        Test.expect(solver.lengthOfLIS(nums1), 4);
        
        int[] nums2 = {0,1,0,3,2,3};
        Test.expect(solver.lengthOfLIS(nums2), 4);
        
        int[] nums3 = {7,7,7,7,7,7,7};
        Test.expect(solver.lengthOfLIS(nums3), 1);

    }
}
