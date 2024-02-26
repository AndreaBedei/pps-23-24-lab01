package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> list = new ArrayList<>();
    private int position = -1;

    @Override
    public void add(int element) {
        if (isEmpty()) {
            position = 0;
        }
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
    public Optional<Integer> next() {
        return isEmpty() ? Optional.empty() : this.takeCorrectElement(position + 1);
    }

    private Optional<Integer> takeCorrectElement(int position) {
        position = position % size();
        return Optional.of(list.get(position));
    }

    @Override
    public Optional<Integer> previous() {
        return isEmpty() ? Optional.empty() : this.takeCorrectElement(position - 1);
    }

    @Override
    public void reset() {
        this.position = isEmpty() ? -1 : 0;
    }
}