package org.example.myUtil.interfaces;


/**
 * Represents a double-ended queue collection.
 *
 * @param <T> the type of elements in the deque
 */
public interface MyDeque<T> extends MyCollection<T>{

    /**
     * Adds an element to the beginning of the deque.
     *
     * @param t the element to add at the beginning
     */
    void addFirst(T t);

    /**
     * Adds an element to the end of the deque.
     *
     * @param t the element to add at the end
     */
    void addLast(T t);

    /**
     * Retrieves the first element in the deque.
     *
     * @return the first element in the deque
     */
    T getFirst();

    /**
     * Retrieves the last element in the deque.
     *
     * @return the last element in the deque
     */
    T getLast();


}
