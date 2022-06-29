class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]='.';
        
        List<List<String>> res=new ArrayList<List<String>>();
        helper(0,board,res,n);
        return res;
    }
    
    //validate funtion to check whether a queen can be placed at a given index
    public boolean validate(int row,int col,char[][] board)
    {
        int duprow=row;
        int dupcol=col;
        
        while(row>=0 && col>=0){
            if(board[row][col]=='Q')return false;
            row--;
            col--;
        }
        row=duprow;
        col=dupcol;
        
        while(col>=0)
        {
            if(board[row][col]=='Q') return false;
            col--;
        }
        row=duprow;
        col=dupcol;
        while(col>=0 && row<board.length )
        {
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        } 
        return true;
    }
    
    
    public void helper(int col,char[][] board,List<List<String>> res,int n)
    {
        if(col==board.length)
        {
            res.add(construct(board));
            return;
        }
        
        for(int row=0;row<board.length;row++)
        {
            if(validate(row,col,board)){
            board[row][col]='Q';
            helper(col+1,board,res,n);
            board[row][col]='.';
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