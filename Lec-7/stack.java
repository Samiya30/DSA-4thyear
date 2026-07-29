import java.util.*;
public class stack {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(digit);
        }
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char ch : stack) {
            if (leadingZero && ch == '0') continue;
            leadingZero = false;
            sb.append(ch);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
