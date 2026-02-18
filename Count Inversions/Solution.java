class Solution {
    static int inversionCount(int arr[]) {
       return mergeSort(arr,0,arr.length-1);
    }
    public static int mergeSort(int[] arr,int l,int h){
        int cnt=0;
        if(l<h){
            int mid=l+(h-l)/2;
            cnt+=mergeSort(arr,l,mid);
            cnt+=mergeSort(arr,mid+1,h);
            cnt+=merge(arr,l,mid,h);
        }
        return cnt;
    }
    public static int merge(int[] arr,int l,int m,int h){
        int inv=0;
        int n=h-l+1;
        int[] temp=new int[n];
        int idx=0;
        int p1=l,p2=m+1;
        while(p1<=m && p2<=h){
            if(arr[p1]<=arr[p2]){
                temp[idx++]=arr[p1++];
            }
            else{
                inv+=(m-p1+1);
                temp[idx++]=arr[p2++];
            }
        }
        while(p1<=m){
            temp[idx++]=arr[p1++];
        }
        while(p2<=h){
            temp[idx++]=arr[p2++];
        }
        for(int i=0;i<n;i++){
            arr[l+i]=temp[i];
        }
        return inv;
    }
}

// APPROACH
// We can use two loops to count the inversions with TC of O(n^2)
// The optimal approach is to use Divide and Conquer strategy to find the number of inversions
//  here we use mergesort kind of logic with a mino changes to the merge operations
// If we are merging two parts whenever we encounter a the value from the right part we increment 
// inversions by no of elements to be added in the left part as they are greater than current right.
// accumulate the sum over all parts of the array and return it

// COMPLEXITIES
// TIME : O(n logn)
// SPACE : O(n)