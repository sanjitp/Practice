class tuple{
    int level;
    int vert;
    TreeNode node;
    public tuple(TreeNode node,int level,int vert)
    {
        this.node=node;
        this.level=level;
        this.vert=vert;
    }
}
class Solution {
     public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        Queue<tuple> que=new LinkedList<>();
        que.offer(new tuple(root,0,0));
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map= new TreeMap<>();
      //BFS
         while(!que.isEmpty())
         {
             int size=que.size();
             tuple t =que.poll();
             TreeNode temp=t.node;
             int vert= t.vert;
             int level=t.level;
             
             if(!map.containsKey(vert))
                 map.put(vert,new TreeMap<>());
             
             if(!map.get(vert).containsKey(level))
                 map.get(vert).put(level,new PriorityQueue<>());
             
             map.get(vert).get(level).offer(temp.val);
             
             if(temp.left!=null)
                 que.offer(new tuple(temp.left,level+1,vert-1));
             if(temp.right!=null)
                 que.offer(new tuple(temp.right,level+1,vert+1));
         }
         
         List<List<Integer>> list=new ArrayList<>();
         
         for(TreeMap<Integer,PriorityQueue<Integer>> ys : map.values())
         {
             list.add(new ArrayList<>());
             for(PriorityQueue<Integer>nodes: ys.values())
             {
                 while(!nodes.isEmpty())
                 {
                     list.get(list.size()-1).add(nodes.poll());
                 }
             }
         }
         return list;
         
    }
}