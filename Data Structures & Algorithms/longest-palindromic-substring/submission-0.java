class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(palindrome(i, j, s)){
                    if(j - i + 1 > res.length()){
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    boolean palindrome(int i, int j, String s){
        int l = i, r = j;
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++; r--;
            }else{
                return false;
            }
        }
        return true;
    }
}
