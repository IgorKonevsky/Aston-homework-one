package org.example.myUtil.interfaces;

import java.util.Iterator;

/**
 * Represents a customized iterator over a collection.
 *
 * @param <T> the type of elements in the iterator
 */
public interface MyIterator<T> extends Iterator<T> {

    /**
     * Checks if there is a previous element available in the iteration.
     *
     * @return true if there is a previous element, false otherwise
     */
    boolean hasPrevious();

    /**
     * Retrieves the previous element in the iteration.
     *
     * @return the previous element in the iteration
     */
    T previous();

    /**
     * Retrieves the index of the element that would be returned by a subsequent call to next().
     *
     * @return the index of the element that would be returned by a subsequent call to next()
     */
    int nextIndex();

    /**
     * Retrieves the index of the element that would be returned by a subsequent call to previous().
     *
     * @return the index of the element that would be returned by a subsequent call to previous()
     */
    int previousIndex();


}
