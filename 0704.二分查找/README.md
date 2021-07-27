## [704. 二分查找](https://leetcode-cn.com/problems/binary-search/)

### 题目详情
> 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

**示例 1:**
```sh
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
```

**示例 2:**
```sh
输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
```

**提示：**
```sh
1. 你可以假设 nums 中的所有元素是不重复的。
2. n 将在 [1, 10000]之间。
3. nums 的每个元素都将在 [-9999, 9999]之间。
```

### 解法
**思路**
1. 设定双指针，low，high
2. 设定中间位置mid，并判断该位置的值是否等于target
3. nums[mid] == target，返回mid
4. nums[mid] < target，则target在 (mid, high]之间，把low移到mid+1处
5. nums[mid] > target，则target在 [low, mid)之间，把high移到mid-1处

1. [Java](./Solution.java)
```java
public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    int mid = 0;
    while (low <= high) {
        mid = (high + low) >> 1;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}
```

2. [Python3](./solution.py)
```python
def search(self, nums: List, target: int) -> int:
    low = 0
    high = len(nums) - 1
    mid = 0
    while low <= high:
        mid = int(low + (high - low) >> 1)
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1
```

3. [Go](./solution.go)
```go
func search(nums []int, target int) int {
	low := 0
	high := len(nums) - 1
	mid := 0
	for low <= high {
		mid = low + (high-low)>>1
		if nums[mid] == target {
			return mid
		} else if nums[mid] < target {
			low = mid + 1
		} else if nums[mid] > target {
			high = mid - 1
		}
	}
	return -1
}
```
