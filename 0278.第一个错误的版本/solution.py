class Solution:
    def firstBadVersion(self, n) -> int:
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        left, right = 1, n
        while left <= right:
            mid = left + (right - left) // 2
            if isBadVersion(mid):
                right = mid - 1
            else:
                left = mid + 1
        return left
