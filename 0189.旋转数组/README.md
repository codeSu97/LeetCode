# [189.旋转数组](https://leetcode-cn.com/problems/rotate-array)

## 题目描述

> 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

**进阶：**

- 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题
- 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？

**示例 1:**

```sh
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
```

**示例 2:**

```sh
输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
```

**提示：**

- 1 <= nums.length <= 2 * 10<sup>4</sup>
- -2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1
- 0 <= k <= 10<sup>5</sup>

## 解法

### 思路**

1. 把数组拆分为两个，[0, k-1)，[k, n-1]
2. 先把整个数组反转
3. 再把两个子数组反转
4. 如果k超过nums的长度，k>len(nums)，那么右移次数k=k%len(nums)

### 实现

[Java](./Solution.java)

```java
public void rotate(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    reverse(nums, 0, n - 1);// 反转整个数组
    reverse(nums, 0, k - 1);// 反转[0, k-1)数
    reverse(nums, k, n - 1);// 反转(k, n-1]数
}

public void reverse(int[] nums, int i, int j) {
    while (i < j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        i++;
        j--;
    }
}
```

[Python3](./solution.py)

```python
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
```

[Go](./solution.go)

```go
func rotate(nums []int, k int) {
    n := len(nums)
    k %= n
    reverse(nums, 0, n-1) // 反转整个数组
    reverse(nums, 0, k-1) // 反转[0, k-1)数
    reverse(nums, k, n-1) // 反转(k, n-1]数
}

func reverse(nums []int, i int, j int) {
    for i < j {
        nums[i], nums[j] = nums[j], nums[i]
        i++
        j--
    }
}
```
