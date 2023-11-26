package org.example.myUtil.interfaces;

import java.util.Comparator;

/**
 * Represents a generic collection of elements.
 *
 * @param <T> the type of elements in the collection
 */
public interface MyCollection<T> extends Iterable<T>{

    /**
     * Adds an element to the collection.
     *
     * @param t the element to add
     */
    void add(T t);

    /**
     * Removes the first occurrence of the specified element from the collection, if it is present.
     *
     * @param t the element to be removed from the collection, if present
     */
    void remove(T t);

    /**
     * Clears all elements from the collection.
     */
    void clear();

    /**
     * Sorts the elements in the collection according to the order induced by the specified Comparator.
     *
     * @param comparator the Comparator to determine the order of elements
     */
    void sort(Comparator<T> comparator);

    /**
     * Retrieves the number of elements in the collection.
     *
     * @return the number of elements in the collection
     */
    int size();

    /**
     * Checks if the collection is empty.
     *
     * @return true if the collection contains no elements, false otherwise
     */
    boolean isEmpty();

    /**
     * Checks if the collection contains the specified element.
     *
     * @param t the element to check for presence in the collection
     * @return true if the collection contains the specified element, false otherwise
     */
    boolean contains(T t);

}
