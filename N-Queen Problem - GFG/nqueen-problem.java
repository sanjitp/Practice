// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // to store answer
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        helper(board,ans,0);
        return ans;
        
    }
    private static void helper(boolean[][] board,ArrayList<ArrayList<Integer>> ans,int row){
        if(row==board.length){
            //a solution is found
            //add it to our list
            add(board,ans);
            return;
        }
        
        for(int col=0;col<board.length;col++){
            //checking whether the queen will be placed safely or not
            if(isSafe(board,row,col)){
                board[row][col]=true;
                helper(board,ans,row+1);
                //backtracking
                board[row][col]=false;
            }
        }
    }
    private static boolean isSafe(boolean[][] board,int row,int col){
        //check the above rows for queens
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        //to check left diagonal
        int maxLeft=Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }
        //to check right diagonal
        int maxRight=Math.min(row,board.length-col-1);
        for(int i=1;i<=maxRight;i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
    
    private static void add(boolean[][] board,ArrayList<ArrayList<Integer>> ans){
        //this function adds solutions to the final answer
        ArrayList<Integer> sub=new ArrayList<Integer>();
        for(int row=0;row<board.length;row++){
            
            for(int col=0;col<board.length;col++){
                if(board[row][col]){
                    sub.add(col+1);
                }
            }
        }
        ans.add(sub);
    }
}