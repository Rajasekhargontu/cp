import java.util.Arrays;

class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        int[] ans = new int[3];
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int sum = Integer.MAX_VALUE, diff = Integer.MAX_VALUE;
        int n = a.length;
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < n && p2 < n && p3 < n) {
            int max = Math.max(a[p1], Math.max(b[p2], c[p3]));
            int min = Math.min(a[p1], Math.min(b[p2], c[p3]));
            if (max - min < diff || (max - min == diff && a[p1] + b[p2] + c[p3] < sum)) {
                ans[0] = a[p1];
                ans[1] = b[p2];
                ans[2] = c[p3];
                sum = a[p1] + b[p2] + c[p3];
                diff = max - min;
            }
            if (a[p1] == min)
                p1++;
            else if (b[p2] == min)
                p2++;
            else
                p3++;
        }
        Arrays.sort(ans);
        int temp = ans[0];
        ans[0] = ans[2];
        ans[2] = temp;
        return ans;
    }
}


// APPROACH
// First sort the three arrays
// Maintain a pointer for each array.
// for each possible pointer configuration take
//      the max and min among them and update the values
//      Move the pointer of the min value to its next Index
// return the values with minimum difference


// COMPLEXITIES
// TIME : O(n log n)
// SPACE : O(n) --> mergesort needs additional space