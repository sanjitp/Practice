class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        find(0,candidates,target,res,new ArrayList<Integer>());
        return res;
    }
    
    public void find(int ind,int[] arr,int target,List<List<Integer>> res,ArrayList<Integer> ans)
    {
        if(ind==arr.length)
        {
            if(target==0)
            {
                res.add(new ArrayList<Integer>(ans));
            }
            return;
        }
        if(arr[ind]<= target)
        {
            ans.add(arr[ind]);
            find(ind,arr,target-arr[ind],res,ans);
            ans.remove(ans.size()-1);
        }
        find(ind+1,arr,target,res,ans);
    }
}