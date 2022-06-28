// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> res=new ArrayList<>();
        helper(0,arr,res,0,N);
        return res;
    }
    public void helper(int ind,ArrayList<Integer> arr,ArrayList<Integer> res,int sum,int n)
    {
        if(ind == n)
        {
            res.add(sum);
            return;
        }
        
        sum+=arr.get(ind);
        helper(ind+1,arr,res,sum,n);
        sum-=arr.get(ind);
        helper(ind+1,arr,res,sum,n);
    }
}