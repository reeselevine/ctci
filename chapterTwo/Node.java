/** Class representing one node in a linked list.
 *  @author Reese Levine
 */
public class Node {

    public int data;
    public Node next = null;

    /** Initializes a new node with DATA */
    public Node(int data) {
        this.data = data;
    }

    /** Utility method that appends a new node
     *  with data D to the end of the list
     *  represented by this node.
     */
    public void appendToTail(int d) {
        Node last = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = last;
    }

    /** Removes duplicate nodes from a linked list, starting
     *  from this node.
     */
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

    /** Finds and returns the Nth to last element of a linked list,
     *  assuming that this node is the start of the list.
     */
    public Node findNode(int i) {
        int count = 0;
        Node n = this;
        while (n.next != null) {
            n = n.next;
            count++;
        }
        if (count - i < 0) return null;
        n = this;
        while (count - i > 0) {
            n = n.next;
            count--;
        }
        return n;
    }
}
