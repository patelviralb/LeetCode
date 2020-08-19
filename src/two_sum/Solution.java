package two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answerArray = new int[2];
        int i;
        int j;
        int difference;
        Map<Integer,Integer> hashNums = new HashMap<>();
        i = 0;
        for(int eachNum:nums) {
            difference = target - eachNum;
            if(hashNums.containsKey(eachNum)) {
                answerArray[0] = hashNums.get(eachNum);
                answerArray[1] = i;
                break;
            }
            hashNums.put(difference,i);
            i++;
        }
        return answerArray;
    }
}
