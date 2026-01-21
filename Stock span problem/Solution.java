import java.util.*;
public class Solution {
    public int[] calculateSpan(int[] arr) {
        int n=arr.length;
        // Monotonically decreasing stack storing indices
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[n];
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                int idx=stack.pop();
                ans[idx]=idx-i;
            }
            stack.push(i);
        }
        int top=stack.pop();
        ans[top]=1;
        while(!stack.isEmpty()){
            int x=stack.pop();
            ans[x]=x-top+1;
        }
        return ans;
    }
}
// APPROACH
// This is a stack based problem where we need to leverage the monotonic arrangement of elemnts.
// We need to find for ach eleent the farthest leftmost index where the number is less than current one.
// To do this efficiently we traverse the array from left to right we use the stack as follows:
//  --- we take the current number and pop from stack all the elements at the top that are less than that number.
// ---then we posh the current number
// After traversing the whole array we take the top element and which is the smallest element to all the elements on the stack
// and update the remaining answers as well

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(n)
