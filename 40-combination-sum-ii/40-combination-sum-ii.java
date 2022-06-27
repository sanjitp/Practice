class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        find(0,candidates,target,res,new ArrayList<Integer>());
        return res;
    }
     public void find(int ind,int[] arr,int target,List<List<Integer>> res,ArrayList<Integer> ans)
    {
          if(target==0)
          {
              res.add(new ArrayList<>(ans));
              return;
          }
         
         for(int i=ind;i<arr.length;i++)
         {
         if(i > ind && arr[i]==arr[i-1])
             continue;
         if(arr[i]>target)
             break;
             ans.add(arr[i]);
         find(i+1,arr,target-arr[i],res,ans);
             ans.remove(ans.size()-1);
         }
    }
        
}