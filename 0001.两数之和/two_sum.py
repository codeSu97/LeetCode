from typing import List


class twoSum:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        创建字典存放数组的值与其对应的下边
        遍历数组，当发现 target-nums[i] 在字典中，则说明找到了
        :param nums: 传入的数组
        :param target: 目标值
        :return: [] 下标
        """
        tmp = {}
        for i, v in enumerate(nums):
            num = target - v
            if num in tmp:
                return [tmp[num], i]
            tmp[v] = i
