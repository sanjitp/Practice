class Solution {
    public List<List<String>> solveNQueens(int n) {
      char[][] board=new char[n][n];
      List<List<String>> res=new ArrayList<List<String>>();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='.';
        int[] left=new int[n];
        int[] ub=new int[2*n-1];
        int[] lb=new int[2*n-1];
        helper(0,res,board,left,ub,lb,n);
        return res;
    }
    public void helper(int col,List<List<String>> res,char[][] board,int[] left,int[] ub,int[] lb,int n)
    {
        if(col==board.length)
        {
            res.add(construct(board));
            return;
        }
        
        for(int row=0;row<board.length;row++)
        {
            if(left[row]==0 && lb[row+col]==0 && ub[board.length-1+col-row]==0 )
            {
                board[row][col]='Q';
                left[row]=1;
                lb[row+col]=1;
                ub[board.length-1 +col-row]=1;
                helper(col+1,res,board,left,ub,lb,n);
                board[row][col]='.';
                left[row]=0;
                lb[row+col]=0;
                ub[board.length-1 +col-row]=0;
            }
        }
    }
    public List<String> construct(char[][] board)
    {
        List<String> res=new LinkedList<String>();
        for(int i=0;i<board.length;i++)
        {
            String s=new String(board[i]);
            res.add(s);
        }
        return res;
    }
}