from typing import List


class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join([_sub[::-1] for _sub in s.split()])

