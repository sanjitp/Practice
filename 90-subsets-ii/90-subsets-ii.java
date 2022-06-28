class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        helper(0,nums,res,new ArrayList<Integer>(),nums.length);
        return res;
    }
    public void helper(int ind,int[] nums,List<List<Integer>> res,List<Integer> ans,int n)
    {
      res.add(new ArrayList<>(ans));
        for(int i=ind;i<nums.length;i++)
        {
            if(i!=ind && nums[i]==nums[i-1])
                continue;
            ans.add(nums[i]);
            helper(i+1,nums,res,ans,n);
            ans.remove(ans.size()-1);
        }
    }
}