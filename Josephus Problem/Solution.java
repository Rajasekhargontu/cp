public class Solution {
    public int josephus(int n, int k) {
       int idx=0;
       for(int i=1;i<=n;i++)
       idx=(idx+k)%i;
       return idx+1;
    }
}
// APPROACH
// In this after a soldier is killed the indes shift by k as the next starting point will be the one next to killed soldier
// since it is in circular fashion we need to we take MOD in orer to wrap around
// The recurrence relation is as follows:
//              jos(n,k)=(jos(n-1,k)+k)%n


// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)