from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def reverse(i: int, j: int) -> None:
            while i < j:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
                j -= 1
        n = len(nums)
        k %= n
        reverse(0, n - 1)  # 反转整个数组
        reverse(0, k - 1)  # 反转[0, k-1)数组
        reverse(k, n - 1)  # 反转(k, n-1]数组
