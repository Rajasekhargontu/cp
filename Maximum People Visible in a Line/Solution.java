import java.util.*;
public class Solution {
public int maxPeople(int[] arr) {
        int ans = 0, n = arr.length;
        // Monotonic stack that stores indexes
        Stack<Integer> stack = new Stack<>();
        // stores index of next greatest element to the left
        int[] ngel=new int[n];
        // stores index of next greatest element to the left
        int[] nger=new int[n];
        Arrays.fill(nger,n);
        Arrays.fill(ngel,-1);
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) ngel[i]=stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) nger[i]=stack.peek();
            stack.push(i);
        }
        // Take the difference between the greatest element to left and right  to find the visibility of index i;
        for(int i=0;i<n;i++) ans=Math.max(ans,nger[i]-ngel[i]-1);
        return ans;
    }
}

// APPROACH
// Compute the next greatest elements to left and right for every index
// Compute the difference b/w them as nextRight - nextLeft - 1
// Take the maximum of the values

// COMPLEXITIES
// Time : O(n)
// SPACE : O(n)