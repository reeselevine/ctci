import static org.junit.Assert.*;
import org.junit.Test;

/** Tests Chapter 2 questions.
 *  @author Reese Levine
 */
public class ChapterTwoTest {

    @Test
    public void testRemoveDuplicates() {
        Node a = new Node(5);
        a.appendToTail(4);
        a.appendToTail(3);
        a.appendToTail(5);
        a.appendToTail(4);
        a.appendToTail(2);
        a.removeDuplicates();
        assertEquals(2, a.next.next.next.data);
        assertEquals(5, a.data);
        a.appendToTail(2);
        a.appendToTail(2);
        a.removeDuplicates();
        assertEquals(2, a.next.next.next.data);
        Node b = new Node(1);
        b.appendToTail(1); b.appendToTail(1);
        b.removeDuplicates();
        assertEquals(null, b.next);
    }

    @Test
    public void testFindNode() {
        Node a = new Node(1);
        a.appendToTail(2); a.appendToTail(3);
        a.appendToTail(4); a.appendToTail(5);
        assertEquals(4, a.findNode(2).data);
        assertEquals(null, a.findNode(6));
        assertEquals(1, a.findNode(5).data);
        assertEquals(5, a.findNode(1).data);
    }

    @Test
    public void testDeleteNode() {
        Node a = new Node(1);
        a.appendToTail(3);
        a.appendToTail(4);
        Node.deleteNode(a.next);
        assertEquals(4, a.next.data);
        Node.deleteNode(a.next);
        assertEquals(4, a.next.data);
    }

    @Test
    public void testAddListsRecursive() {
        Node a = new Node(3);
        a.appendToTail(2);
        Node b = new Node(4);
        b.appendToTail(5);
        Node c = new Node(7);
        c.appendToTail(7);
        Node d = Node.addLists(a, b, false);
        assertEquals(c.data, d.data);
        assertEquals(c.next.data, d.next.data);

        c = new Node(1);
        c.appendToTail(3);
        c.appendToTail(1);
        Node e = Node.addLists(b, d, false);
        assertEquals(c.data, e.data);
        assertEquals(c.next.data, e.next.data);
        assertEquals(c.next.next.data, e.next.next.data);

        a = new Node(7);
        b = new Node(8);
        b.appendToTail(9);
        b.appendToTail(4);
        c = new Node(5);
        c.appendToTail(0);
        c.appendToTail(5);
        d = Node.addLists(a, b, false);
        assertEquals(c.next.data, d.next.data);
        d = Node.addLists(b, a);
        assertEquals(c.next.next.data, d.next.next.data);

        a = null;
        c = Node.addLists(a, b, false);
        assertEquals(b.data, c.data);
    }
    
    @Test
    public void testAddLists() {
        Node a = new Node(3);
        a.appendToTail(2);
        Node b = new Node(4);
        b.appendToTail(5);
        Node c = new Node(7);
        c.appendToTail(7);
        Node d = Node.addLists(a, b);
        assertEquals(c.data, d.data);
        assertEquals(c.next.data, d.next.data);

        c = new Node(1);
        c.appendToTail(3);
        c.appendToTail(1);
        Node e = Node.addLists(b, d);
        assertEquals(c.data, e.data);
        assertEquals(c.next.data, e.next.data);
        assertEquals(c.next.next.data, e.next.next.data);

        a = new Node(7);
        b = new Node(8);
        b.appendToTail(9);
        b.appendToTail(4);
        c = new Node(5);
        c.appendToTail(0);
        c.appendToTail(5);
        d = Node.addLists(a, b);
        assertEquals(c.next.data, d.next.data);
        d = Node.addLists(b, a);
        assertEquals(c.next.next.data, d.next.next.data);

        a = null;
        c = Node.addLists(a, b);
        assertEquals(b.data, c.data);
    }
}
