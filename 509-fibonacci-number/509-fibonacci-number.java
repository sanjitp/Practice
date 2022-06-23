class Solution {
    public int fib(int n) {
     
        int[] arr=new int[n+1];
        Arrays.fill(arr,-1);
        int res= fib(n,arr);
        return res;
    }
    
    public int fib(int n,int[] arr)
    {
        if(n<=1)
            return n;
        if(arr[n]!=-1)
            return arr[n];
        return arr[n]=fib(n-1,arr)+fib(n-2,arr);
    }
}