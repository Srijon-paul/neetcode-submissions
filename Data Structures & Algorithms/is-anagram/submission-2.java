class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(!map1.get(s.charAt(i)).equals(map2.get(s.charAt(i)))){
                return false;
            }
        }
        return true;
    }
}
