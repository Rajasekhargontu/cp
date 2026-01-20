import java.util.*;
class Solution {
    // Used to store the text
    StringBuilder sb=new StringBuilder();
    // Used to Store the undo operations performed
    Stack<Character> redo=new Stack<>();
    public void append(char x) {
        // The redo stack is of no use as there are no latest undone
        redo.clear();
        sb.append(x);
    }

    public void undo() {
        // Take the last character added and move it to redo stack by removing it
        if(sb.length()>0){
            char ch=sb.charAt(sb.length()-1);
            redo.push(ch);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public void redo() {
        // Take the character at the top of redo stack and add it string.
        if(!redo.isEmpty()) sb.append(redo.pop());
    }

    public String read() {
        // return the string to the user
        return sb.toString();
    }
}

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(n)