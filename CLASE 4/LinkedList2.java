public class LinkedList2 {
    private Node2 head;

    public Node2 getHead() {
        return head;
    }

    public void setHead(Node2 head) {
        this.head = head;
    }

    public void add(Object o) {
        if (head == null) {
            head = new Node2(o);
        } else {
            Node2 newHead = new Node2(o);
            newHead.setNextnNode(head);
            head = newHead;
        }
    }

    @Override
    public String toString() {
        Node2 iter = head;
        StringBuilder sb = new StringBuilder();
        while (iter != null) {
            if (sb.length() > 0) sb.append(",");
            sb.append(iter.getData());
            iter = iter.getNextnNode();
        }
        return sb.toString();
    }

    public int size() {
        Node2 iter = head;
        int size = 0;
        while (iter != null) {
            size++;
            iter = iter.getNextnNode();
        }
        return size;
    }

    public void delete(int index) {
        if (head == null) return;
        if (index == 0) {
            head = head.getNextnNode();
            return;
        }
        Node2 iter = head;
        int i = 0;
        while (iter != null && iter.getNextnNode() != null) {
            if (i + 1 == index) {
                iter.setNextnNode(iter.getNextnNode().getNextnNode());
                return;
            }
            iter = iter.getNextnNode();
            i++;
        }
    }
}
