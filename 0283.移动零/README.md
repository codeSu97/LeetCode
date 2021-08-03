# [283.移动零](https://leetcode-cn.com/problems/move-zeroes/)

## 题目描述

> 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

**示例:**

```sh
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
```

**说明:**

1. 必须在原数组上操作，不能拷贝额外的数组。
2. 尽量减少操作次数。

## 解法

### 思路

1. 使用快慢双指针，slow, fast = 0, 0
2. 如果 fast == 0，那么fast++
3. 如果 fast != 0，那么slow和fast交换，并且 slow++, fast++

### 实现

[Java](./Solution.java)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast <= nums.length - 1) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                fast++;
                slow++;
            }
        }
    }
}
```

[Python3](./solution.py)

```python
def moveZeroes(self, nums: List[int]) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    slow, fast = 0, 0  # 快慢双指针
    while fast <= len(nums) - 1:
        if nums[fast] == 0:
            fast += 1
        else:
            nums[slow], nums[fast] = nums[fast], nums[slow]
            slow += 1
            fast += 1
```

[Go](./solution.go)

```go
func moveZeroes(nums []int) {
    slow, fast := 0, 0
    for fast <= len(nums)-1 {
        if nums[fast] == 0 {
            fast++
        } else {
            nums[slow], nums[fast] = nums[fast], nums[slow]
            slow++
            fast++
        }
    }
}
```
