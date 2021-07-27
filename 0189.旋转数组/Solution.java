public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);// 反转整个数组
        reverse(nums, 0, k - 1);// 反转[0, k-1)数
        reverse(nums, k, n - 1);// 反转(k, n-1]数
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
