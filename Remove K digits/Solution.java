import java.util.*;
public class Solution {
    public String removeKdig(String s, int k) {
        // Monotonic stack to store digits in ascending order
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            while(k>0 && !stack.isEmpty() && stack.peek()>ch){
                k--;
                stack.pop();
            }
            stack.push(ch);
        }
        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }
        // used to return the final answer
        StringBuilder sb=new StringBuilder();
        boolean zeroStart=true;
        for(char ch:stack){
            if(zeroStart && ch=='0') continue;
            zeroStart=false;
            sb.append(ch);
        }
        if(sb.length()==0) return "0";
        return sb.toString();
    }
}
// APPROACH
// Our goal is to minimize the number as smaller as possible
// a number is consdered smaller if there is a smaller digit towards the left i.e. we need to make sure that digits to the left are smaller.
// To achieve this we initialise a stack to store the digits.
// If the current digit is greater or equal to stack top then we simply push it onto stack
// Otherwise just go on poping until k>0 or the top become less the curr
// Pop until k>0 and skip the bottom 0's on the stack
// return the new String based on stack digits

// COMPLEXITIES
// TIME: O(n)
// SPACE: O(n)