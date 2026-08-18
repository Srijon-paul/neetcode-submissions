class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                st.push(s.charAt(i));
                i++;
            } else {
                // important to check the stack is empty or not since it can happen that there is directly a closing bracket.
                if (!st.isEmpty() && s.charAt(i) == ']' && st.peek() == '[') {
                    i++;
                    st.pop();
                } else if (!st.isEmpty() && s.charAt(i) == '}' && st.peek() == '{') {
                    i++;
                    st.pop();
                } else if (!st.isEmpty() && s.charAt(i) == ')' && st.peek() == '(') {
                    i++;
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }
}
