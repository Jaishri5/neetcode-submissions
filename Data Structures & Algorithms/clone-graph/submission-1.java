/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        
       // List<List<Integer> adj=new ArrayList<>();
        Node head=new Node(node.val);
        ArrayDeque<Node> q1=new ArrayDeque<>();
        ArrayDeque<Node> q2=new ArrayDeque<>();
        q1.push(node);
        q2.push(head);
        HashMap<Integer,Node> map=new HashMap<>();
        map.put(node.val,head);
        while(!q1.isEmpty()){
            Node currHead=q1.poll();
            Node curr=q2.poll();
            
            for(int i=0;i<currHead.neighbors.size();i++){
                Node n=currHead.neighbors.get(i);
                if(!map.containsKey(n.val)){
                    q1.add(n);
                    Node newNode=new Node(n.val);
                    map.put(n.val,newNode);
                    curr.neighbors.add(newNode);
                   // newNode.neighbors.add(curr);
                    q2.add(newNode);
                }
                else{
                    
                    curr.neighbors.add(map.get(n.val));
                }

                
            }



        }
        return head;
        
        
        
       
    }
}