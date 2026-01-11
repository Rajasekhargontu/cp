class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // queue that stores indexes of elements in monotonic order
        Deque<Integer> queue=new LinkedList<>();
        // stores maximum of every k length subarray
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            // while adding an element remove elements that are smaller than current element
            while(!queue.isEmpty() && arr[queue.peekLast()]<arr[i]) queue.removeLast();
            // add the curr element to the end of queue
            queue.addLast(i);
        }
        for(int i=k;i<arr.length;i++){
            ans.add(arr[queue.peekFirst()]);
            // remove all the indexes from the front of queue that are beyond K distance from out current position
            while(!queue.isEmpty() && queue.peekFirst() <= i-k) queue.removeFirst();
            // while adding an element remove elements that are smaller than current element
            while(!queue.isEmpty() && arr[queue.peekLast()]<arr[i]) queue.removeLast();
            // Add the element to the End of queue
            queue.addLast(i);
        }
        ans.add(arr[queue.peekFirst()]);
        return ans;
    }
    public static void main(String[] args){
        int[] testcase1={1, 2, 3, 1, 4, 5, 2, 3, 6};
        int[] testcase2={5, 1, 3, 4, 2};
        System.out.println(maxOfSubarrays(testcase1,3));
        System.out.println(maxOfSubarrays(testcase2,1));
    }
}

// APPROACH
// An element can be part of sunarray of length 2*K - 1
// We process elements from left to right and use a monotonic queue like datastructure to store contenders for the maximum element
// If we encounted a greater element the we can gracefully remove all the elements that are smaller than that as they are no longer be possible answers
// the first element in the queue will be the Largest element of subarray ending at K
// Timely check if the front of queue is within k distance or not and remove the invalid indexes.



// TIME COMPLEXITY : O(n)
// SPACE COMPLEXITY : O(k) as the queue can have a maximum of k elements at any time
