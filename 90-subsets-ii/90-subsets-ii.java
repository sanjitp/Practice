class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        helper(0,nums,res,new ArrayList<Integer>());
        return res;
    }
    public void helper(int ind,int[] nums,List<List<Integer>> res,List<Integer> ds)
    {
        res.add(new ArrayList<>(ds));
        for(int i=ind;i<nums.length;i++)
        {
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            helper(i+1,nums,res,ds);
            ds.remove(ds.size()-1);
        }
    }
}