# [278. 第一个错误的版本](https://leetcode-cn.com/problems/first-bad-version/)

## 题目描述

> 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
> 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
>
> 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
>
> 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
> 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

**示例 1：**

```sh
输入：n = 5, bad = 4
输出：4
解释：
调用 isBadVersion(3) -> false
调用 isBadVersion(5) -> true
调用 isBadVersion(4) -> true
所以，4 是第一个错误的版本。
```

**示例 2：**

```sh
输入：n = 1, bad = 1
输出：1
```

**提示：**
1 <= bad <= n <= 2<sup>31</sup> - 1

## 解法

### 思路

尽量减少对 isBadVersion()的调用

因为一定有个错误的版本，那么n=1时，返回1

使用二分查找，双指针，low=1，high=n，mid=high/2

1. 如果mid为false:
    1. mid+1 为true，那么第一个错误版本为mid+1
    2. mid+1 为fasle，那么第一个错误版本，在(mid+1, n]之间
2. 如果mid为true：
    1. mid-1 为false，那么第一个错误版本为mid
    2. mid-1 为true，那么第一个错误版本在[1, mid-1)之间

### 实现

[Java](./Solution.java)

```java
public int firstBadVersion(int n) {
    if (n == 1) {
        return 1;
    }
    int left = 1, right = n;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return left;
}
```

[Python3](./solution.py)

```python
def firstBadVersion(self, n):
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
```

[Go](./solution.go)

```go
func firstBadVersion(n int) int {
    if n == 1 {
        return 1
    }
    left, right := 1, n
    for left <= right {
        mid := left + (right-left)>>1
        if isBadVersion(mid) {
            right = mid - 1
        } else {
        left = mid + 1
        }
    }
    return left
}
```
