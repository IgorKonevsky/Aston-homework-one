package org.example.myUtil.implementations;


import org.example.myUtil.interfaces.MyIterator;
import org.example.myUtil.interfaces.MyList;

import java.util.*;

/**
 * Custom realization of ArrayList class
 * MyArrayList class implements the MyList interface providing functionalities similar to ArrayList.
 *
 * @param <T> the type of elements in this list
 */
public class MyArrayList<T> implements MyList<T> {

    /**
     * Default initial capacity of the list
     */
    private final int DEFAULT_CAPACITY = 10;

    /**
     * Storage for list's elements
     */
    private Object[] elementArray;
    /**
     * Current size of the list
     */
    private int size;

    // Constructors

    /**
     * Constructs a MyArrayList with a default capacity.
     */
    public MyArrayList() {

        this.elementArray = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Constructs a MyArrayList with the specified initial capacity.
     *
     * @param capacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified capacity is less than or equal to 0
     */
    public MyArrayList(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        this.elementArray = new Object[capacity];
        this.size = 0;
    }

    // Private Methods

    /**
     * Ensures the capacity of the internal array to accommodate new elements.
     */
    private void ensureCapacity() {

        if (size == elementArray.length) {
            Object[] array = new Object[(elementArray.length * 3 / 2) + 1];

            System.arraycopy(elementArray, 0, array, 0, size);
            elementArray = array;
        }

    }

    /**
     * Checks if the given index is valid.
     *
     * @param index the index to be checked
     * @throws IllegalArgumentException if the index is out of bounds
     */
    private void checkIndex(int index) {

        if (index > size || index < 0) {
            throw new IllegalArgumentException("Index must be greater than 0 and less than collection's size ");

        }

    }

    /**
     * Trims the internal array to the current size.
     */
    private void trimToSize() {

        if (size < elementArray.length) {
            elementArray = Arrays.copyOf(elementArray, size);
        }
    }

    // Public Methods (from MyList interface)

    /**
     * Adds the specified element to the end of the list.
     *
     * @param t the element to add
     */
    @Override
    public void add(T t) {

        ensureCapacity();

        elementArray[size] = t;
        size++;
    }

    /**
     * Adds the specified element at the specified index in the list.
     *
     * @param t     the element to add
     * @param index the index at which to add the element
     */
    @Override
    public void add(T t, int index) {

        checkIndex(index);

        ensureCapacity();
        if (index == 0) {

            Object[] array = new Object[elementArray.length];

            array[0] = t;
            System.arraycopy(elementArray, 0, array, 1, elementArray.length - 1);

            elementArray = array;
            size++;

        } else if (index == size) {
            add(t);

        } else {
            System.arraycopy(elementArray, index, elementArray, index + 1, elementArray.length - index - 1);
            elementArray[index] = t;
            size++;
        }
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param t     the element to be stored at the specified position
     * @param index the index of the element to replace
     */
    @Override
    public void set(T t, int index) {
        checkIndex(index);
        elementArray[index] = t;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param t the element to be removed from this list, if present
     */
    @Override
    public void remove(T t) {

        for (int i = 0; i < size; i++) {
            if (elementArray[i].equals(t)) {
                remove(i);
            }
        }

    }

    /**
     * Removes the element at the specified index in this list.
     *
     * @param index the index of the element to be removed
     */
    @Override
    public void remove(int index) {
        checkIndex(index);

        System.arraycopy(elementArray, index + 1, elementArray, index, elementArray.length - index - 1);
        size--;
    }

    /**
     * Returns an array containing all the elements in this list in proper sequence.
     *
     * @return an array containing all the elements in this list in proper sequence
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementArray, size);
    }

    /**
     * Removes all the elements from this list.
     */
    @Override
    public void clear() {

        elementArray = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Sorts this list according to the order induced by the specified Comparator.
     *
     * @param comparator the Comparator to determine the order of elements
     */
    @Override
    public void sort(Comparator<T> comparator) {
        Arrays.sort((T[]) elementArray, 0, size, comparator);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if this list is empty.
     *
     * @return true if this list contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     * Checks if this list contains the specified element.
     *
     * @param t the element to check for presence in the list
     * @return true if this list contains the specified element, false otherwise
     */
    @Override
    public boolean contains(T t) {

        for (int i = 0; i < size; i++) {
            T currentElement = (T) elementArray[i];
            if (t.equals(currentElement))
                return true;
        }
        return false;

    }


    /**
     * Retrieves the element at the specified index in this list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index in this list
     */
    @Override
    public T get(int index) {
        return (T) elementArray[index];
    }

    /**
     * Returns an iterator over the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    /**
     * A custom iterator for the MyArrayList class.
     */
    private class MyArrayListIterator implements MyIterator<T> {

        /**
         * Index representing the current position of the iterator.
         */
        int currentIndex;
        /**
         * Index representing the position of the last returned element.
         */
        int indexOfLastReturnedElement = -1;

        /**
         * Constructs a new iterator starting at the beginning of the list.
         */
        MyArrayListIterator() {
            currentIndex = 0;
        }


        /**
         * Checks whether there is a next element available in the list.
         *
         * @return true if there is a next element, false otherwise
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        /**
         * Retrieves the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if there is no next element available
         */
        @Override
        public T next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T currentElement = (T) elementArray[currentIndex];
            indexOfLastReturnedElement = currentIndex;
            currentIndex += 1;
            return currentElement;

        }

        /**
         * Checks whether there is a previous element available in the list.
         *
         * @return true if there is a previous element, false otherwise
         */
        @Override
        public boolean hasPrevious() {
            return currentIndex > 0;
        }

        /**
         * Retrieves the previous element in the iteration.
         *
         * @return the previous element in the iteration
         * @throws NoSuchElementException if there is no previous element available
         */
        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            T currentElement = (T) elementArray[currentIndex];
            indexOfLastReturnedElement = currentIndex;
            currentIndex -= 1;
            return currentElement;
        }

        /**
         * Retrieves the index of the element that would be returned by a subsequent call to next().
         *
         * @return the index of the element that would be returned by a subsequent call to next()
         */
        @Override
        public int nextIndex() {
            return currentIndex + 1;
        }

        /**
         * Retrieves the index of the element that would be returned by a subsequent call to previous().
         *
         * @return the index of the element that would be returned by a subsequent call to previous()
         */
        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }


    }
}
