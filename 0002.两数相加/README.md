# [2. 两数相加](https://leetcode-cn.com/problems/add-two-numbers/)

## 题目描述

> 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
>
> 请你将两个数相加，并以相同形式返回一个表示和的链表。
>
> 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

**示例 1：**

```sh
2  ->  4  ->  3
5  ->  6  ->  4
---------------
7  ->  0  ->  8
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
```

**示例 2：**

```sh
输入：l1 = [0], l2 = [0]
输出：[0]
```

**示例 3：**

```sh
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
```

**提示：**

- 每个链表中的节点数在范围 [1, 100] 内
- 0 <= Node.val <= 9
- 题目数据保证列表表示的数字不含前导零

## 解法

### 思路

1. 两条链表相加，返回的结果要求是链表，每次插值的时候都要在链表的尾端添加。
   需要一个返回结果的链表res，需要一个指针，每次添加后都指向最后一个节点。
2. 如果有进数(两数想和大于十进1)，下次相加时一起加上。
3. 两条链表长度可能不相等，因此结束循环后，需要判断是否有未遍历完的链表，有则单独遍历，没有则进入下一步。
4. 当两条链表都遍历结束，还需要判断进数是否为0，为0什么也不做，不为0在运行结果的链表尾部添加值为1的节点。
5. 最后可以直接返回res链表

### 实现

[Java](./Solution.java)

```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode tl = new ListNode(-1);
    ListNode l = tl;
    int num = 0;
    int newNum = 0;
    while (l1 != null || l2 != null || num > 0) {
        newNum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + num;
        num = newNum / 10;
        l.next = new ListNode(newNum % 10);
        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;
        l = l.next;
    }
    return tl.next;
}
```

[Python3](./solution.py)

```python
def twoSum(self, nums: List[int], target: int) -> List[int]:
    tmp = {}
    for i, v in enumerate(nums):
        num = target - v
        if num in tmp:
            return [tmp[num], i]
        tmp[v] = i
```

[Go](./solution.go)

```go
func twoSum(nums []int, target int) []int {
    m := make(map[int]int)
    for i := 0; i < len(nums); i++ {
        n := target - nums[i]
        if _, ok := m[n]; ok {
            return []int{m[n], i}
        }
        m[nums[i]] = i
    }
    return nil
}
```
