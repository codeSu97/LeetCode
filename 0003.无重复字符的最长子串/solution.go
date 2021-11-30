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
