class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums.length-1,nums,dp);
    }
    public int helper(int ind,int[] nums,int[] dp)
    {
        if(ind==0)
            return nums[ind];
        if(ind < 0)
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        int pick=nums[ind]+ helper(ind-2,nums,dp);
        int notpick= 0+ helper(ind-1,nums,dp);
        return dp[ind]=Math.max(pick,notpick);
    }
}