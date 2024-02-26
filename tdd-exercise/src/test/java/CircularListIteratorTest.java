import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tddIterator.*;

public class CircularListIteratorTest {
    CircularList circularList;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
    }

    @Test
    void checkListEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    void checkSizeList(){
        assertEquals(circularList.size(), 0);
    }

    @Test
    void checkAddFirstElementToTheListSize(){
        circularList.add(0);
        assertEquals(circularList.size(), 1);
    }

    @Test
    void checkAddFirstElementToTheListEmpty(){
        checkAddFirstElementToTheListSize();
        assertFalse(circularList.isEmpty());
    }

    @Test
    void checkTheNextElementByIteratorInEmptyList(){
        assertFalse(circularList.forwardIterator().hasNext());
    }

    @Test
    void checkTakeTheNextElementByIteratorInEmptyList(){
        assertThrows(IllegalStateException.class, () -> circularList.forwardIterator().next());
    }

    @Test
    void checkTakeTheNextElementByIterator(){
        circularList.add(0);
        assertEquals(circularList.forwardIterator().next(), 0);
    }

    @Test
    void checkTakeTheSameSecondNextElementByIterator(){
        circularList.add(0);
        Iterator<Integer> iterator = circularList.forwardIterator();
        assertEquals(iterator.next(), 0);
    }

    @Test
    void checkTakeTheSecondNextElementByIterator(){
        circularList.add(0);
        circularList.add(1);
        Iterator<Integer> iterator = circularList.forwardIterator();
        iterator.next();
        assertEquals(iterator.next(), 1);
    }

    @Test
    void checkThePreviousElementByIteratorInEmptyList(){
        assertFalse(circularList.backwardIterator().hasNext());
    }

    @Test
    void checkTakeThePreviousElementByIteratorInEmptyList(){
        assertThrows(IllegalStateException.class, () -> circularList.backwardIterator().next());
    }

    @Test
    void checkTakeThePreviousElementByIterator(){
        circularList.add(0);
        assertEquals(circularList.backwardIterator().next(), 0);
    }

    @Test
    void checkTakeTheSecondPreviousElementByIterator(){
        circularList.add(0);
        Iterator<Integer> iterator = circularList.backwardIterator();
        iterator.next();
        assertEquals(iterator.next(), 0);
    }
}
