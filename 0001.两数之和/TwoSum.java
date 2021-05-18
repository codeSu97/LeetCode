import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 创建字典存放数组的值与其对应的下标 遍历数组，当发现 target-nums[i] 在字典中，则说明找到了
     *
     * @param nums   传入的数组
     * @param target 目标值
     * @return int[下标, 下标]
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int n = target - nums[i];
            if (map.containsKey(n)) {
                return new int[] { map.get(n), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}