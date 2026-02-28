import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        int m=0,n=arr2.length-1;
        int n1=-1,n2=-1;
        int diff=Integer.MAX_VALUE;
        while(m<arr1.length && n>=0){
            int sum=arr1[m]+arr2[n];
            if(Math.abs(sum-x)<diff){
                n1=arr1[m];
                n2=arr2[n];
                diff=Math.abs(sum-x);
            }
            if(sum > x) n--;
            else m++;
        }
        return new ArrayList<Integer>(Arrays.asList(n1, n2));
    }
}

// APPROACH
// We use two pointer approach here where one points to start of one array and other to the end of array.
// Calculate the absolute difference and update each values
// If the current sum is greater then decrease the pointer started on right side otherwise increment pointer started on left

// COMPLEXITIES
// TIME : O(n+m)
// SPACE : O(1)