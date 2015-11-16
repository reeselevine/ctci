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
        if (i == 0) return null;
        Node a = this;
        Node b = this;
        for (int j = i - 1; j > 0; j--) {
            a = a.next;
            if (a == null) return null;
        }
        while (a.next != null) {
            a = a.next;
            b = b.next;
        }
        return b;
    }

    /** Deletes the given node from the linked list. 
     * Is unsolvable in the case that the given node is
     * the last node in the linked list.
     */
    public static void deleteNode(Node node) {
        if (node == null || node.next == null) return;
        node.data = node.next.data;
        node.next = node.next.next;
    }

    /** Adds together two linked lists, where the ones digit
     *  is the head of the list, the tens digit is the next, etc.
     *  Returns the head of the summed list.
     *  Does not support negative numbers
     */
    public static Node addLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = (l1.data + l2.data) / 10;
        Node result = new Node((l1.data + l2.data) % 10);
        Node toReturn = result;
        while (l1.next != null && l2.next != null) {
            result.next = new Node((carry + l1.next.data + l2.next.data) % 10);
            carry = (carry + l1.next.data + l2.next.data) / 10;
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }
        while (l1.next != null) {
            result.next = new Node((carry + l1.next.data) % 10);
            carry = (carry + l1.next.data) / 10;
            result = result.next;
            l1 = l1.next;
        }
        while (l2.next != null) {
            result.next = new Node((carry + l2.next.data) % 10);
            carry = (carry + l2.next.data) / 10;
            result = result.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            result.next = new Node(carry);
        }
        return toReturn;
    }
}
