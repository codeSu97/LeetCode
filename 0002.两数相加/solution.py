from typing import List


def twoSum(self, nums: List[int], target: int) -> List[int]:
    tmp = {}
    for i, v in enumerate(nums):
        num = target - v
        if num in tmp:
            return [tmp[num], i]
        tmp[v] = i
