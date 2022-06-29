// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    vector<vector<int>> uniquePerms(vector<int> arr ,int n) {
        // code here
        map<vector<int>,int>mp;
       vector<int>ds;
       vector<bool>freq(n,false);
       
       solve(arr,n,mp,ds,freq);
       vector<vector<int>>ans;
       for(auto it:mp){
           ans.push_back(it.first);
       }
       return ans;
    }
    void solve(vector<int>&arr,int n,map<vector<int>,int>&mp,vector<int>&ds,vector<bool>&freq){
     if(ds.size()==n){
         mp[ds]++;
         return;
     }
     for(int i=0;i<arr.size();i++){
         if(freq[i]!=true){
             freq[i]=true;
             ds.push_back(arr[i]);
             solve(arr,n,mp,ds,freq);
             freq[i]=false;
             ds.pop_back();
         }
     }
    }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        
        cin>>n;
        vector<int> arr(n);
        
        for(int i=0 ; i<n ; i++)
            cin>>arr[i];

        Solution ob;
        vector<vector<int>> res = ob.uniquePerms(arr,n);
        for(int i=0; i<res.size(); i++)
        {
            for(int j=0; j<n; j++)
            {
                cout<<res[i][j]<<" ";
            }
            cout<<"\n";
        }
    }
    return 0;
}  // } Driver Code Ends