class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            // thinking of this as how the character indexing will be done in array to get the actual index in the arr to count
            arr[s.charAt(i) - 'a'] += 1;
            arr[t.charAt(i) - 'a'] -= 1;
        }
        for(int i = 0; i < 26; i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
