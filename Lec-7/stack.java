import java.util.*;
public class stack {
    //remove k digits
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


    //remove duplicate letters
     public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']--;
            if (visited[ch - 'a']) {
                continue;
            }
            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && freq[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }


    //largest rectangle in histogram
     public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
     }
}
