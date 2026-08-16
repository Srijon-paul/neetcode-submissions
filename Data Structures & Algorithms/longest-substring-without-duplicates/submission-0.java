class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        HashMap<Character, Integer> map = new HashMap<>();
        int low = 0, high = 0, res = 0;

        while (high < s.length()) {
            // needs check since if at high if already present then start removing low until char at high disappears
            while(map.containsKey(s.charAt(high))){
                map.put(s.charAt(low), map.get(s.charAt(low)) - 1);
                if(map.get(s.charAt(low)) == 0){
                    map.remove(s.charAt(low));
                }
                low++; 
            }
            // then add high and check the length
            map.put(s.charAt(high), map.getOrDefault(s.charAt(high), 0) + 1);
            res = Math.max(res, high - low + 1);
            high++;
        }
        return res;
    }
}
