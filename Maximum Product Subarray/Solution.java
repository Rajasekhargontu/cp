class Solution {
    int maxProduct(int[] arr) {
        int res=arr[0];
        int f=arr[0],g=arr[0];
        for(int i=1;i<arr.length;i++){
            int ff=f;
            // max ending at index i is max(start here,extend +ve part,extend -ve part)
            f=Math.max(arr[i],Math.max(f*arr[i],g*arr[i]));
            // min ending at index i is max(start here,extend +ve part,extend -ve part)
            g=Math.min(arr[i],Math.min(ff*arr[i],g*arr[i]));
            //Max of global max,ending at index i
            res=Math.max(res,f);
        }
        return res;
    }
}

// COMPLEXITIES
// TIME : O(n)
// SPACE : O(1)