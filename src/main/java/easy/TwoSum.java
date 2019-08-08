package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args){
        twoSum(new int[]{3, 2, 4}, 6);

    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //这段应该很好理解，在往map里面插入数据的同时，检测目前map是否已经有达到条件的数，且只会循环一次，不会出现key重叠的情况
        for (int i = 0 ; i<nums.length ; i++){
            if (map.containsKey(target - nums[i]))
                return new int[]{i,map.get(target - nums[i])};
            map.put(nums[i], i);
        }
        return null;
    }
}
