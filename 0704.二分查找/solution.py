from typing import List


class Solution:

    def search(self, nums: List, target: int) -> int:
        low = 0
        high = len(nums) - 1
        mid = 0
        while low <= high:
            mid = low + (high - low) >> 1  # low + (high - low) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
