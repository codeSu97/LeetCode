## [2. 两数相加](https://leetcode-cn.com/problems/add-two-numbers/)

### 题目描述
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
```
输入：l1 = [0], l2 = [0]
输出：[0]
```

**示例 3：**
```
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
```

**提示：**
- 每个链表中的节点数在范围 [1, 100] 内
- 0 <= Node.val <= 9
- 题目数据保证列表表示的数字不含前导零

### 解法
**思路**
由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。

我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。具体而言，如果当前两个链表处相应位置的数字为 n1,n2n1,n2，进位值为 \textit{carry}carry，则它们的和为 n1+n2+\textit{carry}n1+n2+carry；其中，答案链表处相应位置的数字为 (n1+n2+\textit{carry}) \bmod 10(n1+n2+carry)mod10，而新的进位值为 \lfloor\frac{n1+n2+\textit{carry}}{10}\rfloor⌊
10
n1+n2+carry
​
 ⌋。

如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 00 。

此外，如果链表遍历结束后，有 \textit{carry} > 0carry>0，还需要在答案链表的后面附加一个节点，节点的值为 \textit{carry}carry。

1. [Java](./Solution.java)
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
2. [Python3](./solution.py)
```python3
def twoSum(self, nums: List[int], target: int) -> List[int]:
    tmp = {}
    for i, v in enumerate(nums):
        num = target - v
        if num in tmp:
            return [tmp[num], i]
        tmp[v] = i
```
3. [Go](./solution.go)
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