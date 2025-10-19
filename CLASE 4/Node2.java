public class Node2 {
    private Object data;
    private Node2 nextnNode;

    public Node2(Object data) {
        this.data = data;
        this.nextnNode = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node2 getNextnNode() {
        return nextnNode;
    }

    public void setNextnNode(Node2 nextnNode) {
        this.nextnNode = nextnNode;
    }
}
