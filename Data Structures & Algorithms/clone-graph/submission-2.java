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
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, null, null, visited);
    }

    private Node dfs(Node node, Node parent, Node parentNew, Map<Node, Node> visited) {
        if (node == null) return null;

        Node newNode = new Node(node.val);

        visited.put(node, newNode);

        if (parentNew != null) {
            newNode.neighbors.add(parentNew);
        }

        for (Node neighbor : node.neighbors) {
            if (neighbor == parent) {
                continue;
            }
            if (visited.containsKey(neighbor)) {
                newNode.neighbors.add(visited.get(neighbor));
                continue;
            }
            newNode.neighbors.add(dfs(neighbor, node, newNode, visited));
        }

        return newNode;
    }
}