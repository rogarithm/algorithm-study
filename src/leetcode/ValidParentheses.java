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
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty()) {
                // s 안 문자가 홀수개일 경우나 s가 닫는 괄호로 시작하는 경우 짝이 안맞으니 멈추고 false 반환
                return false;
            } else if (stack.pop() != c) {
                // 스택에서 꺼낸 문자가 일치하면 다음 반복문으로 넘어가고 일치하지 않으면 짝이 안맞으니 멈추고 false 반환
                return false;
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            // 여는 괄호 하나만 있을 경우는 반복문 빠져나와도 스택이 비어있지 않지만 짝이 없으니 false를 반환해야 한다
            return false;
        }
    }
}
