class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int resLen = 0, resIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > resLen) {
                        resLen = r - l + 1;
                        resIndex = l;
                    }
                    l--; r++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > resLen) {
                        resLen = r - l + 1;
                        resIndex = l;
                    }
                    l--; r++;
                } else {
                    break;
                }
            }
        }
        return s.substring(resIndex, resIndex + resLen);
    }
}
