class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> res=new ArrayList<>();
      List<Integer> ans=new ArrayList<>();
      boolean[] freq=new boolean[nums.length];
        helper(nums,res,ans,freq);
        return res;
    }
    
    public void helper(int[] nums,List<List<Integer>> res,List<Integer> ans,boolean[] freq)
    {
        if(ans.size()==nums.length)
        {
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(!freq[i]){
            ans.add(nums[i]);
            freq[i]=true;
            helper(nums,res,ans,freq);
            freq[i]=false;
            ans.remove(ans.size()-1);
            }
        }
    }
}