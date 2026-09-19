class Solution {
    public int reverse(int x) {
        int org = x;
        x = Math.abs(x);
        String str = new StringBuilder(Integer.toString(x)).reverse().toString();
        if(str.charAt(str.length() - 1) == '-') str = str.substring(0, str.length() - 1);
        long res = Long.parseLong(str);
        if(org < 0){
            res = res * -1;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return 0;
        }
        return (int) res;
    }
}
