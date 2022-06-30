class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> ans=new ArrayList<>();
        int fact=1;
        for(int i=1;i<n;i++)
        {
            fact=fact*i;
            ans.add(i);
        }
        ans.add(n);
        String s="";
        k=k-1;
        
        while(true)
        {
            s=s+ ans.get(k/fact);
            ans.remove(k/fact);
            if(ans.size()==0)
                break;
            k= k % fact;
            fact= fact/ans.size();
        }
        return s;
    }
}