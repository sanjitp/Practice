class Solution {
    public int climbStairs(int n) {
        if(n==1)
            return n;
     int[] dp=new int[n+1];
     Arrays.fill(dp,-1);
     helper(dp,n);
     return dp[n];
    }
    
    public int helper(int[] dp,int n)
    {
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]= helper(dp,n-1)+helper(dp,n-2);
    }
}