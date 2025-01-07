import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');

        Stack<Character> seen = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (closeToOpen.containsKey(curr)) {
                if (seen.isEmpty() || seen.pop() != closeToOpen.get(curr))
                    return false;
            } else seen.push(curr);
        }
        return seen.isEmpty();
    }
}
