class Solution {
    public static int catchThieves(char[] arr, int k) {
        // t--> Index of thief
        // p --> index of police
        // caught --> no of thieves caught by police
        int p=0,t=0,caught=0;
        while(p<arr.length && t<arr.length){
            // make sure p point to police 
            if(arr[p]!='P'){
                p++;
                continue;
            }
            // make sure t point to thief
            if(arr[t]!='T'){
                t++;
                continue;
            }
            // If they are >k apart then move the one with lower position
            if(p<t && t-p >k) p++;
            else if(p>t && p-t>k) t++;
            else{
                // catch the thief and proceed to next indexes
                caught++;
                t++;
                p++;
            }
        }
        return caught;
    }
    public static void main(String[] args) {
        char[] arr={'T', 'T', 'P', 'P', 'T', 'P'};
        System.out.println(catchThieves(arr,3));
    }
}

// APPROACH
// We use two pointer approach to solve this problem 
// we use two variables to track the indexes of police and the thief
// If at any point they are greater than k distance apart then we need to skip the one to the left
// If we found any indexes wee increment the answer and increment both position to next valid indexes


// COMPLEXITY
// Time: O(n)
// SPACE:O(1)