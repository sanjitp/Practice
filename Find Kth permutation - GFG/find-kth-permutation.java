// { Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            Solution obj = new Solution();
            String res = obj.kthPermutation(a[0],a[1]);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static String kthPermutation(int n,int k) {
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
        
