# [155.最小栈](https://leetcode-cn.com/problems/min-stack)

## 题目详情

设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

实现 MinStack 类:

- MinStack() 初始化堆栈对象。
- void push(int val) 将元素val推入堆栈。
- void pop() 删除堆栈顶部的元素。
- int top() 获取堆栈顶部的元素。
- int getMin() 获取堆栈中的最小元素。

**示例 1:**

```shell
输入:
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出:
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
```

**提示:**

- -2<sup>31</sup> <= val <= 2<sup>31</sup> - 1
- pop、top 和 getMin 操作总是在 非空栈 上调用
- push, pop, top, and getMin最多被调用 3 * 10<sup>4</sup> 次

## 解法

### 思路

1. 空间换时间
2. 普通栈的push、pop、top操作都是O(1)，min()需要遍历所有元素，那么需要借助第二个栈来完成min()操作
3. 第二个栈`min_stack`从大到小存放数据，把`x`压入主栈`main_stack`的同时保证`min_stack`的栈顶一直是最小值：
   1. 若`min_stack`没有值，则把`x`压入`min_stack`
   2. 若`min_stack`有值且`x`小于等于`min_stack`的栈顶，则把`x`压入`min_stack`
4. min()函数取`min_stack`的栈顶

### 实现

[Python3](./solution.py)

```python
class MinStack:

    def __init__(self):
        self.main_stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.main_stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self) -> None:
        if self.main_stack.pop() == self.min_stack[-1]:
            self.min_stack.pop()

    def top(self) -> int:
        return self.main_stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
```
