public class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        int[] result = new int[nums.length];
        while (i <= j) {
            int im = nums[i] * nums[i];
            int jm = nums[j] * nums[j];
            if (im < jm) {
                result[k] = jm;
                j--;
            } else {
                result[k] = im;
                i++;
            }
            k--;
        }
        return result;
    }
}
