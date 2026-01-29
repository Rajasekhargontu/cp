import java.util.*;
class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        int n=q.size();
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=q.remove();
        for(int i=0;i<n/2;i++){
            q.offer(nums[i]);
            q.offer(nums[n/2+i]);
        }
    }
}

// APPROACH
// First add all elements to an array
// Later add one element from start and one from the middle into the queue.

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(n)