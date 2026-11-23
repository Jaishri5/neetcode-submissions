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
        Node head=new Node(node.val);
        ArrayDeque<Node> q1=new ArrayDeque<>();
        q1.offer(node);
        HashMap<Node,Node> map=new HashMap<>();
        map.put(node,head);
        while(!q1.isEmpty()){
            Node currHead=q1.poll();
            Node curr=map.get(currHead);
            for(Node n:currHead.neighbors){
                if(!map.containsKey(n)){
                    q1.offer(n);
                    Node newNode=new Node(n.val);
                    map.put(n,newNode);
                }
                curr.neighbors.add(map.get(n));
            }
        }
        return head;
    }
}