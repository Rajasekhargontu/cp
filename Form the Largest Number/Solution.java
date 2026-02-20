import java.util.Arrays;

class Solution {
    public String findLargest(int[] nums) {
        Integer[] arr=new Integer[nums.length];
        for(int i=0;i<nums.length;i++) arr[i]=nums[i];
        Arrays.sort(arr,(a,b)->{
            return -(""+a+b).compareTo(""+b+a);
        });
        StringBuilder sb=new StringBuilder();
        for(Integer i:arr) sb.append(Integer.toString(i));
        if(sb.charAt(0)=='0') return "0";
        return sb.toString();
    }
}

// APPROACH
// We sort the array based on whether (a + b) yields greater number or (b + a) yields greater number
// Concatenate all these values to a String.

// COMPLEXITIES
// TIME : O(n log n)
// SPACE : O(n)