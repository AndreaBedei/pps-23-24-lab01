import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

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
    void checkAddFirstElementToTheListIsEmpty(){
        checkAddFirstElementToTheListSize();
        assertFalse(circularList.isEmpty());
    }

    @Test
    void checkEmptyNextElement(){
        assertEquals(circularList.next(), Optional.empty());
    }

    @Test
    void checkNextElement(){
        circularList.add(0);
        circularList.add(1);
        assertEquals(circularList.next(), Optional.of(1));
    }

    @Test
    void checkResetWithEmptyList(){
        circularList.reset();
        assertEquals(circularList.next(), Optional.empty());
    }

    @Test
    void checkPreviousElement(){
        circularList.add(0);
        circularList.add(1);
        assertEquals(circularList.next(), Optional.of(1));
    }
}
