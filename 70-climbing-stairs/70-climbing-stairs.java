class Solution {
    public int climbStairs(int n) {
     
        int[] arr=new int[n+1];
        Arrays.fill(arr,-1);
        fib(n,arr);
        return arr[n];
    }
    
    public int fib(int n,int[] arr)
    {
        if(n<=1)
            return arr[n]=1;
        if(arr[n]!=-1)
            return arr[n];
        arr[n]=fib(n-1,arr)+fib(n-2,arr);
        return arr[n];
    }
}