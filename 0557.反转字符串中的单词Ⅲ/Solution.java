class Solution {
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
}