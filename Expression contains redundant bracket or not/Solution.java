import java.util.*;
class Solution {
    public static boolean checkRedundancy(String s) {
        // Stack to store each character
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(') stack.push(ch);
            else if(ch==')'){
                int len=0;
                while(!stack.isEmpty() && stack.peek()!='('){
                    len++;
                    stack.pop();
                }
                if(!stack.isEmpty()) stack.pop();
                if(len==1) return true;
                else stack.push('x');
            }
            else stack.push(ch);
        }
        return false;
    }
}


// APPROACH
// Scan the expression character by character from left to right
// If the current character is '(' or any alphabet add it to the stack
// If we encounter a ')' then pop characters until you find '(' at the top 
// while popping make sure that you have encountered at least one operand or the charcetrs you popped are greater than 1
// If satisfied return false else return true

// COMPLEXITIES
// TIME: O(n)
// SPACE: O(n)