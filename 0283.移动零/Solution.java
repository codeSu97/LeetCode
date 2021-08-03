class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast <= nums.length - 1) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                fast++;
                slow++;
            }
        }
    }
}