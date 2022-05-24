class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> rows,prev=null;
        
        for(int i=0;i<numRows;i++)
        {
            rows=new ArrayList<>();
            for(int j=0;j<=i;j++){
            if(j==0 || j==i)
                rows.add(1);
            else
            rows.add(prev.get(j-1)+prev.get(j));
        }
            res.add(rows);
            prev=rows;
        }
        return res;
    }
}