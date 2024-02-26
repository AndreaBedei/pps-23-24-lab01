package tddFinder;

import java.util.Optional;
import java.util.function.Predicate;

public interface CircularList extends tdd.CircularList {

    /**
     * Search in the list the next element that satisfies a given condition.
     * @param condition the condition.
     * @return the element.
     */
    public Optional<Integer> filteredNext(Predicate<Integer> condition);
}
