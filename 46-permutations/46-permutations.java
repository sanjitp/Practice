class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> ds=new ArrayList<>();
        boolean[] freq=new boolean[nums.length];
        helper(nums,res,ds,freq);
        return res;
    }
    public static  void helper(int[] nums,List<List<Integer>> res,ArrayList<Integer> ds,boolean[] freq)
    {
        if(ds.size()==nums.length){
        res.add(new ArrayList<>(ds));
        return;
        }
        for(int i=0; i<nums.length;i++)
        {
            if(!freq[i])
            {
                freq[i]= true;
                ds.add(nums[i]);
                helper(nums,res,ds,freq);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
}
}