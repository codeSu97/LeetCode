import java.util.HashMap;

class Solution {
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
}