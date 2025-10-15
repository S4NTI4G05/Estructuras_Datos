public class Node {
    private Object data;
    private Node nextnNode;

    public Node(Object data) {
        this.data = data;
        this.nextnNode = null;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Node getNextnNode() {
        return nextnNode;
    }
    public void setNextnNode(Node nextnNode) {
        this.nextnNode = nextnNode;
    }   
}