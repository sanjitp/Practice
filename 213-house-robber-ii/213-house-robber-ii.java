class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        
        if(n==1)
            return nums[0];
        int[] temp1=new int[n-1];
        int[] temp2=new int[n-1];
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(i!=0) temp1[j++]=nums[i];
            if(i!=n-1)temp2[i]=nums[i];
        }
        
        return Math.max(findMaxSum(temp1,temp1.length),findMaxSum(temp2,temp2.length));
    }
    
    int findMaxSum(int arr[], int n) {
        int prev=arr[0];
        int prev2=0;
        
        for(int i=1;i<n;i++)
        {
            int pick=arr[i];
            if(i>1)
            pick+=prev2;
            int notpick=0+prev;
            int curri=Math.max(pick,notpick);
            
            prev2=prev;
            prev=curri;
        }
        return prev;
    }
}