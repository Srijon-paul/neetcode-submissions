class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0, high = 0, res = 0, count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(high < s.length()){
            map.put(s.charAt(high), map.getOrDefault(s.charAt(high), 0) + 1);
            count = Math.max(count, map.get(s.charAt(high)));
            high++;
            int len = high - low;
            int diff = len - count;

            while(diff > k){
                map.put(s.charAt(low), map.get(s.charAt(low)) - 1);
                if(map.get(s.charAt(low)) == 0){
                    map.remove(s.charAt(low));
                }
                low++;
                len = high - low;
                diff = len - count;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
