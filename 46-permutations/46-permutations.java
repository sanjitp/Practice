class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        helper(0,nums,res);
        return res;
    }
    
    public void swap(int a,int b,int[] nums)
    {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
        
    }
    public void helper(int ind,int[] nums,List<List<Integer>> res)
    {   
        // if ind reaches end store the swapped array in a ds since it's a combination
        if(ind==nums.length)
        {
            List<Integer> ds=new ArrayList<>();
            for(int i =0;i<nums.length;i++)
               ds.add(nums[i]);
            res.add(ds);
            return;
        }
        
        for(int i=ind;i<nums.length;i++)
        {
            swap(i,ind,nums);
            helper(ind+1,nums,res);
            swap(i,ind,nums);
        }
    }
}