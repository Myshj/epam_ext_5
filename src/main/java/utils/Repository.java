package utils;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Generic repository for objects.
 *
 * @param <T>
 */
public class Repository<T> {
    /**
     * Collection to store objects in.
     */
    private final ArrayList<T> data = new ArrayList<>();

    /**
     * Adds new element to repository.
     *
     * @param element Element to add.
     */
    public void add(T element) {
        data.add(element);
    }

    /**
     * Removes element from repository.
     *
     * @param element Element to remove
     */
    public void remove(T element) {
        data.remove(element);
    }

    /**
     * Empties repository.
     */
    public void removeAll() {
        data.clear();
    }

    /**
     * Returns all elements managed by repository.
     *
     * @return All elements managed by repository.
     */
    public ArrayList<T> all() {
        return new ArrayList<>(data);
    }

    /**
     * Returns all elements that satisfy specification.
     *
     * @param specification Specification to satisfy.
     * @return All elements that satisfy specification.
     */
    public ArrayList<T> filter(Predicate<T> specification) {
        ArrayList<T> ret = new ArrayList<>();
        for (T element : data) {
            if (specification.test(element)) {
                ret.add(element);
            }
        }
        return ret;
    }
}
