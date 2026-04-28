import java.util.Stack;
class validParentheses {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                st.push(c);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char top=st.pop();
                if((c==')'&&top!='(')||(c=='}'&&top!='{')||(c==']'&&top!='[')){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        validParentheses vp = new validParentheses();
        String s = "()[]{}";
        boolean result = vp.isValid(s);
        System.out.println(result); // Output: true
    }
}