# [876. 链表的中间节点](https://leetcode-cn.com/problems/middle-of-the-linked-list/)

## 题目详情

> 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
>
> 如果有两个中间结点，则返回第二个中间结点。

**示例 1：**

```sh
输入：[1,2,3,4,5]
输出：此列表中的结点 3 (序列化形式：[3,4,5])
返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
注意，我们返回了一个 ListNode 类型的对象 ans，这样：
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
```

**示例 2：**

```sh
输入：[1,2,3,4,5,6]
输出：此列表中的结点 4 (序列化形式：[4,5,6])
由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
```

**提示：**

- 给定链表的结点数介于 1 和 100 之间。

## 解法

### 思路

#### 快慢指针

1. slow，fast快慢指针，slow每次走一步，fast每次走两步，当fast走完，slow刚好在中间

#### 单指针遍历

1. 第一次遍历，计算出链表长度N
2. 第二次遍历，遍历到 N/2 结束

### 实现

[Java](./Solution.java)

```java
// 快慢指针
public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

// 单指针遍历
public ListNode middleNode_1(ListNode head) {
    int n = 0;
    ListNode cur = head;
    while (cur != null) {
        n++;
        cur = cur.next;
    }
    int k = 0;
    cur = head;
    while (k < n / 2) {
        k++;
        cur = cur.next;
    }
    return cur;
}
```

[Python3](./solution.py)

```python
# 快慢指针
def middleNode(self, head: ListNode) -> ListNode:
    slow = fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    return slow

# 单指针遍历
def middleNode(self, head: ListNode) -> ListNode:
    n, cur = 0, head
    while cur:
        n += 1
        cur = cur.next
    k, cur = 0, head
    while k < n // 2:
        k += 1
        cur = cur.next
    return cur
```

[Go](./solution.go)

```go
// 快慢指针
func middleNode(head *ListNode) *ListNode {
    if head.Next == nil {
        return head
    }

    slow, fast := head.Next, head.Next
    for fast.Next != nil && fast.Next.Next != nil {
        fast, slow = fast.Next.Next, slow.Next
    }

    return slow
}
```
