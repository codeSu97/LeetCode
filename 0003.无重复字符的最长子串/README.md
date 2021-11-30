# [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

## 题目描述

> 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

**示例 1：**

```sh
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

**示例 2：**

```sh
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

**示例 3：**

```sh
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

**示例 4：**

```sh
输入: s = ""
输出: 0
```

**提示：**

- 0 <= s.length <= 5 * 10<sup>4</sup>
- s 由英文字母、数字、符号和空格组成

## 解法

### 思路

1. 滑动窗口
2. 定义快慢指针start, end
3. 每次循环，end++，当该字符在[start:end]中，即重复字符
4. 这时应该把窗口的开始挪到第一个重复字符的下个位置

### 实现

[Java](./Solution.java)

```java
public int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) return 0;

    int start = 0, end = 0, ans = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    while (end < s.length()) {
        if (map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) >= start) {
            start = map.get(s.charAt(end)) + 1;
        }
        map.put(s.charAt(end), end);
        ans = Math.max(ans, end - start + 1);
        end++;
    }
    return ans;
}
```

[Python3](./solution.py)

```python
def lengthOfLongestSubstring(self, s: str) -> int:
    if s == '':
        return 0
    start, end, ans = 0, 0, 0
    kv = dict()
    while end < len(s):
        if s[end] in kv and kv[s[end]] >= start:
            start = kv[s[end]] + 1

        kv[s[end]] = end
        ans = max(ans, end - start + 1)
        end += 1

    return ans
```

[Go](./solution.go)

```go
package main

func lengthOfLongestSubstring(s string) int {
	start, end, ans := 0, 0, 0
	window := make(map[byte]int)

	for end < len(s) {
		_, ok := window[s[end]]
		if ok && window[s[end]] >= start {
			start = window[s[end]] + 1
		}
		window[s[end]] = end
		ans = max(ans, end-start+1)
		end++
	}

	return ans
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
```
