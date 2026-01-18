import java.util.*;
class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        int n=arr.length;
        // HashMap to store frequencies
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr) map.put(i,map.getOrDefault(i,0)+1);
        // Stack that keeps track of next greatest element
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++) ans.add(-1);
        stack.push(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            while(!stack.isEmpty() && map.get(stack.peek())<=map.get(arr[i])) stack.pop();
            if(!stack.isEmpty()) ans.set(i,stack.peek());
            stack.push(arr[i]);
        }
        return ans;
    }
}
// APPROACH
// First we keep track of frequencies of each element using a hashmap
// then we traverse from right to left and try to find the next elemnt that has greater frequency using a stack
// We maintain the stakin such a way that the top will contain the answer for the current index
// We collect all the answers in an arrayList and return it

// COMPLEXITIES
// TIME: O(n)
// SPACE: O(n)