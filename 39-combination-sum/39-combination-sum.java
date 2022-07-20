class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        find(0,candidates,target,res,new ArrayList<Integer>());
        return res;
    }
    
    public void find(int ind,int[] arr,int target,List<List<Integer>> res,List<Integer> ds)
    {
        if(arr.length==ind)
        {
            if(target==0)
            {
                res.add(new ArrayList<Integer>(ds));
            }
            return;
        }
        if(arr[ind]<=target)
        {
            ds.add(arr[ind]);
            find(ind,arr,target-arr[ind],res,ds);
            ds.remove(ds.size()-1);
        }
        find(ind+1,arr,target,res,ds);
    }
}