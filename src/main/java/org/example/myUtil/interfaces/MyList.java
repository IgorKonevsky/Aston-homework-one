package org.example.myUtil.interfaces;

/**
 * Represents a list collection providing indexed access to elements.
 *
 * @param <T> the type of elements in the list
 */
public interface MyList<T> extends MyCollection<T>{


    /**
     * Adds an element at the specified index in the list.
     *
     * @param t     the element to add
     * @param index the index at which to add the element
     */
    void add(T t, int index);

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param t     the element to be stored at the specified position
     * @param index the index of the element to replace
     */
    void set(T t, int index);

    /**
     * Retrieves the element at the specified index in this list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index in this list
     */
    T get(int index);

    /**
     * Removes the element at the specified index in this list.
     *
     * @param index the index of the element to be removed
     */
    void remove(int index);

    /**
     * Returns an array containing all the elements in this list.
     *
     * @return an array containing all the elements in this list
     */
    Object[] toArray();



}
