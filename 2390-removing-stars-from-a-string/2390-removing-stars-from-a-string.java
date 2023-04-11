class Solution {
    public String removeStars(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (Character ch: charArray) { 
            if (ch == '*') { 
                stack.pop();
            } else { 
                stack.push(ch);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) { 
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }
}