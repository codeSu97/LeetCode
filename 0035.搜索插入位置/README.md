# [35.搜索插入位置](https://leetcode-cn.com/problems/search-insert-position)

## 题目详情

> 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
>
> 请必须使用时间复杂度为 O(log n) 的算法。

**示例 1:**

```sh
输入: nums = [1,3,5,6], target = 5
输出: 2
```

**示例 2:**

```sh
输入: nums = [1,3,5,6], target = 2
输出: 1
```

**示例 3:**

```sh
输入: nums = [1,3,5,6], target = 7
输出: 4
```

**示例 4:**

```sh
输入: nums = [1,3,5,6], target = 0
输出: 0
```

**示例 5:**

```sh
输入: nums = [1], target = 0
输出: 0
```

**提示:**

- 1 <= nums.length <= 10<sup>4</sup>
- -10<sup>4</sup>4 <= nums[i] <= 10<sup>4</sup>
- nums 为无重复元素的升序排列数组
- -10<sup>4</sup>4 <= target <= 10<sup>4</sup>

## 解法

### 思路

1. 设定双指针，left，right
2. 设定中间位置mid，并且判断该位置的值是否等于target
3. nums[mid] == target，返回mid
4. nums[mid] < target，则target在 (mid, high]之间，把low移到mid+1处
5. nums[mid] > target，则target在 [low, mid)之间，把high移到mid-1处
6. 若没找到该值，那么target应该插入当前left处

### 实现

[Java](./Solution.java)

```java
public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return left;
}
```

[Python3](./solution.py)

```python
def searchInsert(self, nums: List[int], target: int) -> int:
    left, right = 0, len(nums) - 1
    while left <= right:
        mid = left + (right - left) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return left
```

[Go](./solution.go)

```go
func searchInsert(nums []int, target int) int {
    left, right := 0, len(nums)-1
    for left <= right {
        mid := left + (right-left)>>1
        if nums[mid] == target {
            return mid
        } else if nums[mid] < target {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return left
}
```
