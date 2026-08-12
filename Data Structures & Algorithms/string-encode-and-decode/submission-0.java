class Solution {
    List<Integer> lst = new ArrayList<>();
    public String encode(List<String> strs) {
        String res = "";
        for(int i = 0; i < strs.size(); i++){
            lst.add(strs.get(i).length());
        }
        for(int i = 0; i < lst.size(); i++){
            for(int j = 0; j < lst.get(i); j++){
                res += strs.get(i).charAt(j);
            }
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int k = 0;
        for(int i = 0; i < lst.size(); i++){
            String res = "";
            for(int j = 0; j < lst.get(i); j++){
                res += str.charAt(k);
                k++;
            }
            strs.add(res);
        }
        return strs;
    }
}
