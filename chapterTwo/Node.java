public class Node {

    public int data;
    public Node next = null;

    public Node(int data) {
        this.data = data;
    }

    public void appendToTail(int d) {
        Node last = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = last;
    }

    public void removeDuplicates() {
        Node n = this;
        while (n != null && n.next != null) {
            Node next = n;
            while (next != null && next.next != null) {
                if (n.data == next.next.data) {
                    next.next = next.next.next;
                } else {
                    next = next.next;
                }
            }
            n = n.next;
        }
    }
}
