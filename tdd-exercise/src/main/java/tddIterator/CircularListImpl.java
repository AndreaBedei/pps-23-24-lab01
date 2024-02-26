package tddIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    private final List<Integer> list = new ArrayList<>();

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<Integer>() {
            private int position = 0;  

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new IllegalStateException("Lista vuota");
                }
                final int element = list.get(position);
                position = (position + 1) % list.size();
                return element;
            }
            
        };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new Iterator<Integer>() {
            private int position = size() - 1;  

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new IllegalStateException("Lista vuota");
                }
                final int element = list.get(position);
                position = (position - 1) % list.size();
                return element;
            }
            
        };
    }

}