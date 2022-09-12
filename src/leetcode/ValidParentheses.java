import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println("}" + vp.isValid("}") + ": false");
        System.out.println("{}" + vp.isValid("{}") + ": true");
        System.out.println("{}{{}}" + vp.isValid("{}{{}}") + ": true");
        System.out.println("(" + vp.isValid("(") + ": false");
        System.out.println("{[}" + vp.isValid("{[}") + ": false");
        System.out.println("[}" + vp.isValid(("[)")) + ": false");
        System.out.println("{[]}" + vp.isValid("{[]}") + ": true");
        System.out.println("{}[]" + vp.isValid("{}[]") + ": true");
        System.out.println("(([]){})" + vp.isValid("(([]){})") + ": true");
        System.out.println("([]){}" + vp.isValid("([]){}") + ": true");
        System.out.println("([)]" + vp.isValid("([)]") + ": false");
        System.out.println("[({(())}[()])]" + vp.isValid("[({(())}[()])]") + ": true");
        System.out.println("{(())}[()]" + vp.isValid("{(())}[()]") + ": true");
        System.out.println("({(())}[()])" + vp.isValid("({(())}[()])") + ": true");
    }

    public boolean isValid(String s) {
        Stack<Character> parenthesesToCheck = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                parenthesesToCheck.push(')');
            } else if (c == '[') {
                parenthesesToCheck.push(']');
            } else if (c == '{') {
                parenthesesToCheck.push('}');
            } else if (parenthesesToCheck.isEmpty()) {
                return false;
            } else if (!parenthesesToCheck.isEmpty() && parenthesesToCheck.pop() != c) {
                return false;
            }
        }

        if (parenthesesToCheck.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
