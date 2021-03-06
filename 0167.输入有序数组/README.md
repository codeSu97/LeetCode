# [167. 两数之和Ⅱ - 第一个错误的版本](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)

## 题目描述

> 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
>
> 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
>
> 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

**示例 1：**

```sh
输入：numbers = [2,7,11,15], target = 9
输出：[1,2]
解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
```

**示例 2：**

```sh
输入：numbers = [2,3,4], target = 6
输出：[1,3]
```

**示例 3：**

```sh
输入：numbers = [-1,0], target = -1
输出：[1,2]
```

**提示：**

- 2 <= numbers.length <= 3 * 10<sup>4</sup>
- -1000 <= numbers[i] <= 1000
- numbers 按 `递增顺序` 排列
- -1000 <= target <= 1000
- 仅存在一个有效答案

## 解法

### 思路

1. 设置 双指针，left = 0，right = nums.length-1
2. 两指针相加 sum
   1. 如果 sum == target，那么当前为唯一解，返回下标+1，[left+1, right+1]
   2. 如果 sum < target，那么把左指针右移一位，left+1
   3. 如果 sum > target，那么把右指针左移一位，right-1
   4. 都不符合，那么返回 [-1, -1]

### 实现

[Java](./Solution.java)

```java
public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        if (sum == target) {
            return new int[] { left + 1, right + 1 };
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return new int[] { -1, -1 };
}
```

[Python3](./solution.py)

```python
def twoSum(self, numbers: List[int], target: int) -> List[int]:
    left, right = 0, len(numbers) - 1
    while left < right:
        sum = numbers[left] + numbers[right]
        if sum == target:
            return [left + 1, right + 1]
        elif sum < target:
            left = left + 1
        else:
            right = right - 1
    return [-1, -1]
```

[Go](./solution.go)

```go
func twoSum(numbers []int, target int) []int {
    left, right := 0, len(numbers)-1
    for left < right {
        sum := numbers[left] + numbers[right]
        if sum == target {
            return []int{left + 1, right + 1}
        } else if sum < target {
            left++
        } else {
            right--
        }
    }
    return []int{-1, -1}
}
```
