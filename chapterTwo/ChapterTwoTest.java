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
}
