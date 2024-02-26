package tddFinder;

import java.util.Optional;
import java.util.function.Predicate;

public class CircularListImpl extends tdd.CircularListImpl implements CircularList {

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> condition) {
        if(super.isEmpty()){
           return Optional.empty();
        }
        for(int i = 0; i < super.size(); i++){
            final int element = super.next().get();
            if (condition.test(element)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }
}
