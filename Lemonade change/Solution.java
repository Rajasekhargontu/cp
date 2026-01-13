class Solution {
    public static boolean canServe(int[] arr) {
        int fives=0,tens=0;
        for(int i:arr){
            if(i==5){
                fives++;
            }
            else if(i==10){
                tens++;
                if(fives>0) fives--;
                else return false;
            }
            else{
                if(tens>0 && fives>0){
                    tens--;
                    fives--;
                }
                else if(fives>=3) fives-=3;
                else return false;
        }
        }
        return true;
    }
    public static void main(String[] args){
        int[] arr={5,5,5,10,5,10,20,10};
        System.out.println(Solution.canServe(arr));
    }
}
//  Approach:
// We need to keep track of no of 5s and 10s we received and no need to track twenties as they can never be part of change
// if we receive a 5 we just take it
// if we receive a 10 then return a 5 if we have else say not possible
// if we receive a 20 then return a 10+5 if possible else a 5+5+5 otherwise say its impossible.

// Complexity:
// TIME: O(n)
// SPACE: O(1)