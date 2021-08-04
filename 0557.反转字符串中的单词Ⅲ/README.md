# [0557. 反转字符串中的单词Ⅲ](https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/)

## 题目描述

> 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

**示例：**

```sh
输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"
```

**提示：**

```sh
在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
```

## 解法

### 思路

#### 思路1

快慢指针，slow=0，fast=0
fast++，遍历，终止条件 `fast < len(s)`

1. if s[fast] == ' '
   1. [slow, fast) 为一个单词，然后交换 slow和fast 的元素，slow++, fast-- ，终止条件 `slow < fast`
   2. slow = fast，fast继续遍历
2. else s[fast] != ' '
    1. fast++
3. 这种思路，不需要创建新的空间，在原有的string上操作，由于Java、python、go等语言中字符串不可变，故不能使用这种方法

#### 思路2

1. 创建一个新字符串
2. 遍历原字符串，找到空格，即为一个单词，把这个单词逆序，放到新字符串当中
3. 遍历完原字符串，得到的新字符串为结果
4. 该思路，需要创建新的空间

### 实现

[Java](./Solution.java)

```java
public String reverseWords(String s) {
    StringBuffer result = new StringBuffer();
    for (int i = 0; i < s.length();) {
        int start = i;
        while (i < s.length() && s.charAt(i) != ' ') {
            i++;
        }
        for (int p = start; p < i; p++) {
            result.append(s.charAt(start + i - 1 - p));
        }
        while (i < s.length() && s.charAt(i) == ' ') {
            result.append(' ');
            i++;
        }
    }
    return result.toString();
}
```

[Python3](./solution.py)

```python
def reverseWords(self, s: str) -> str:
    return ' '.join([_sub[::-1] for _sub in s.split()])
```

[Go](./solution.go)

```go
func reverseWords(s string) string {
    length := len(s)
    ret := []byte{}
    for i := 0; i < length; {
        start := i
        for i < length && s[i] != ' ' {
            i++
        }
        for p := start; p < i; p++ {
            ret = append(ret, s[start+i-1-p])
        }
        for i < length && s[i] == ' ' {
            i++
            ret = append(ret, ' ')
        }
    }
    return string(ret)
}
```
