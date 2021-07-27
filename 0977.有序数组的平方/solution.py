from typing import List


class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        i, j, k = 0, len(nums) - 1, len(nums) - 1
        result = [None] * len(nums)
        while i <= j:
            im = nums[i] ** 2
            jm = nums[j] ** 2
            if im < jm:
                result[k] = jm
                j -= 1
            else:
                result[k] = im
                i += 1
            k -= 1
        return result
