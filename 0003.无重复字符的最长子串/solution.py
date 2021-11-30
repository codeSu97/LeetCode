class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start, end, ans = 0, 0, 0
        kv = dict()

        while end < len(s):
            if s[end] in kv and kv[s[end]] >= start:
                start = kv[s[end]] + 1

            kv[s[end]] = end
            ans = max(ans, end - start + 1)
            end += 1

        return ans
