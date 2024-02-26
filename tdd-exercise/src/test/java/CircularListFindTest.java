import tddFinder.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

public class CircularListFindTest {
    CircularList circularList;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
    }

    @Test
    void finderTestOneElement(){
        circularList.add(0);
        assertEquals(circularList.filteredNext( number -> number % 2 == 0 ).get(), 0);
    }

    @Test
    void finderTestNoFindElement(){
        circularList.add(1);
        assertEquals(circularList.filteredNext( number -> number % 2 == 0 ), Optional.empty());
    }

    @Test
    void finderTestSecondElementCorrectFinder(){
        finderTestOneElement();
        circularList.add(2);
        assertEquals(circularList.filteredNext( number -> number % 2 == 0 ).get(), 2);
    }
}
