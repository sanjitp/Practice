/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        Queue<TreeNode> que=new LinkedList<>();
        StringBuilder str=new StringBuilder();
        que.add(root);
        while(!que.isEmpty())
        {
            TreeNode temp=que.poll();
            if(temp==null){
                str.append("n ");
                continue;
            }
            str.append(temp.val+" ");
            que.add(temp.left);
            que.add(temp.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")
            return null;
        Queue<TreeNode> que= new LinkedList<>();
        String[] value=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(value[0]));
        que.add(root);
        for(int i=1;i<value.length;i++)
        {
            TreeNode parent=que.poll();
            if(!value[i].equals("n"))
            {
                TreeNode left=new TreeNode(Integer.parseInt(value[i]));
                que.add(left);
                parent.left=left;
            }
            if(!value[++i].equals("n"))
           {
               TreeNode right=new TreeNode(Integer.parseInt(value[i]));
               parent.right=right;
               que.add(right);
           }
        }
            return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));