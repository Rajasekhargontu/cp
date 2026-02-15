// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        Collections.sort(arr);
        int ans=Integer.MAX_VALUE;
        for(int i=m-1;i<arr.size();i++){
            ans=Math.min(ans,arr.get(i)-arr.get(i-m+1));
        }
        return ans;
    }
}
//APPROACH
//The question is another way of asking the smallest range of m Integers in a given list
//So we sort the array and use two pointers such that there are atleast m integers between.