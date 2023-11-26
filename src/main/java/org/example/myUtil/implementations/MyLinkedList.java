package org.example.myUtil.implementations;

import org.example.myUtil.interfaces.MyDeque;
import org.example.myUtil.interfaces.MyIterator;
import org.example.myUtil.interfaces.MyList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Custom implementation of a linked list.
 * MyLinkedList class implements the MyList and MyDeque interfaces providing functionalities similar to LinkedList.
 *
 * @param <T> the type of elements in this linked list
 */
public class MyLinkedList<T> implements MyDeque<T>, MyList<T> {

    /**
     * Represents the first node in the linked list.
     */
    private Node<T> firstNode;
    /**
     * Represents the last node in the linked list.
     */
    private Node<T> lastNode;

    /**
     * Represents the size of the linked list.
     */
    private int size;

    /**
     * Constructs an empty linked list.
     */
    public MyLinkedList() {
        size = 0;

    }

    // Private methods

    /**
     * Checks whether the given index is valid.
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
     * Finds the node at the specified index in the linked list.
     *
     * @param index the index of the node to find
     * @return the node at the specified index
     */
    private Node<T> findNodeByIndex(int index) {
        checkIndex(index);

        Node<T> node;
        int currentIndex;

        if (size / 2 > index) {
            currentIndex = 0;
            node = firstNode;
            while (currentIndex != index) {
                node = node.nextNode;
                currentIndex++;

            }
        } else {
            currentIndex = size - 1;
            node = lastNode;
            while (currentIndex != index) {
                node = node.previousNode;
                currentIndex--;
            }
        }


        return node;
    }

    /**
     * Converts an array to a linked list.
     *
     * @param array the array to be converted
     * @return a linked list containing elements from the array
     */
    private MyLinkedList<T> arrayToLinkedList(T[] array) {
        MyLinkedList<T> list = new MyLinkedList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);

        }
        return list;
    }

    /**
     * Adds an element to the beginning of the linked list.
     *
     * @param t the element to add at the beginning
     */
    @Override
    public void addFirst(T t) {

        if (size == 0) {
            this.add(t);
        } else {
            Node<T> newNode = new Node<>(t);
            newNode.nextNode = firstNode;
            newNode.previousNode = null;
            firstNode.previousNode = newNode;
            firstNode = newNode;
            size++;
        }

    }

    /**
     * Adds an element to the end of the linked list.
     *
     * @param t the element to add at the end
     */
    @Override
    public void addLast(T t) {
        this.add(t);
    }

    /**
     * Retrieves the first element in the linked list.
     *
     * @return the first element in the linked list
     */
    @Override
    public T getFirst() {
        return firstNode.value;
    }

    /**
     * Retrieves the last element in the linked list.
     *
     * @return the last element in the linked list
     */
    @Override
    public T getLast() {
        return lastNode.value;
    }

    /**
     * Adds an element to the end of the linked list.
     *
     * @param t the element to add at the end
     */
    @Override
    public void add(T t) {

        if (size == 0) {
            firstNode = new Node<>(t);
            lastNode = firstNode;

        } else {
            Node<T> newNode = new Node<>(t);
            newNode.previousNode = lastNode;
            lastNode.nextNode = newNode;
            lastNode = newNode;

        }
        size++;

    }

    /**
     * Adds an element at the specified index in the linked list.
     *
     * @param t     the element to add
     * @param index the index at which to add the element
     */
    @Override
    public void add(T t, int index) {
        Node<T> newNode = new Node<>(t);
        Node<T> node = findNodeByIndex(index);
        newNode.previousNode = node.previousNode;
        newNode.nextNode = node;
        node.previousNode.nextNode = newNode;
        node.previousNode = newNode;
        size++;

    }

    /**
     * Removes the first occurrence of the specified element from the linked list, if it is present.
     *
     * @param t the element to be removed from the linked list, if present
     */
    @Override
    public void remove(T t) {
        Node<T> node = firstNode;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(t)) {
                remove(i);

            }
            node = node.nextNode;
        }
    }

    /**
     * Removes the element at the specified index in the linked list.
     *
     * @param index the index of the element to be removed
     */
    @Override
    public void remove(int index) {
        Node<T> node = findNodeByIndex(index);
        if (index != size - 1) {

            node.nextNode.previousNode = node.previousNode;
        } else {
            node.previousNode.nextNode = null;
        }
        if (index != 0) {
            node.previousNode.nextNode = node.nextNode;
        } else {
            node.nextNode.previousNode = null;
        }
        node.value = null;
        node.previousNode = null;
        node.nextNode = null;
        size--;
    }

    /**
     * Clears all elements from the linked list.
     */
    @Override
    public void clear() {
        Node<T> node = firstNode;

        for (int i = 0; i < size; i++) {
            Node<T> nextNode = node.nextNode;
            node.value = null;
            node.previousNode = null;
            node.nextNode = null;
            node = nextNode;

        }
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    /**
     * Sorts the elements in the linked list according to the order induced by the specified Comparator.
     *
     * @param comparator the Comparator to determine the order of elements
     */
    @Override
    public void sort(Comparator<T> comparator) {
        Object[] array = this.toArray();
        Arrays.sort((T[]) array, 0, size, comparator);
        MyLinkedList<T> sortedLinkedList = arrayToLinkedList((T[]) array);
        clear();
        this.firstNode = sortedLinkedList.firstNode;
        this.lastNode = sortedLinkedList.lastNode;
        this.size = sortedLinkedList.size;

    }


    /**
     * Retrieves the number of elements in the linked list.
     *
     * @return the number of elements in the linked list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the linked list is empty.
     *
     * @return true if the linked list contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     * Checks if the linked list contains the specified element.
     *
     * @param t the element to check for presence in the linked list
     * @return true if the linked list contains the specified element, false otherwise
     */
    @Override
    public boolean contains(T t) {

        Node<T> node = firstNode;

        for (int i = 0; i < size; i++) {
            if (node.value != null && node.value.equals(t)) {
                return true;
            }
        }
        return false;

    }


    /**
     * Replaces the element at the specified position in this linked list with the specified element.
     *
     * @param t     the element to be stored at the specified position
     * @param index the index of the element to replace
     */
    @Override
    public void set(T t, int index) {
        Node<T> node = findNodeByIndex(index);
        node.value = t;
    }

    /**
     * Retrieves the element at the specified index in this linked list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index in this linked list
     */
    @Override
    public T get(int index) {

        Node<T> node = findNodeByIndex(index);
        return node.value;
    }

    /**
     * Returns an array containing all the elements in this linked list in proper sequence.
     *
     * @return an array containing all the elements in this linked list in proper sequence
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> node = firstNode;
        for (int i = 0; i < size; i++) {
            array[i] = node.value;
            node = node.nextNode;

        }
        return array;
    }

    /**
     * Returns an iterator over the elements in this linked list.
     *
     * @return an iterator over the elements in this linked list
     */
    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }


    /**
     * Custom iterator for the MyLinkedList class.
     */
    private class MyLinkedListIterator implements MyIterator<T> {


        /**
         * Represents the node of the last returned element.
         */
        Node<T> lastReturnedNode;

        /**
         * Represents the current node in the iteration.
         */
        Node<T> currentNode;

        /**
         * Represents the current index in the iteration.
         */
        int currentIndex;

        /**
         * Constructs a new iterator for the linked list starting at the beginning.
         */
        MyLinkedListIterator() {
            currentNode = firstNode;
            currentIndex = 0;
        }

        /**
         * Checks if there is a next element available in the iteration.
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
            lastReturnedNode = currentNode;
            currentNode = currentNode.nextNode;
            currentIndex++;

            return lastReturnedNode.value;

        }

        /**
         * Checks if there is a previous element available in the iteration.
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

            lastReturnedNode = currentNode;
            currentNode = currentNode.previousNode;
            currentIndex--;
            return lastReturnedNode.value;

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

    /**
     * Represents a node in the linked list.
     *
     * @param <T> the type of elements in the node
     */
    private static class Node<T> {

        /**
         * Represents the value stored in the node.
         */
        T value;

        /**
         * Represents the previous node.
         */
        Node<T> previousNode;

        /**
         * Represents the next node.
         */
        Node<T> nextNode;

        /**
         * Constructs a node with the specified value.
         *
         * @param value the value to be stored in the node
         */
        Node(T value) {
            this.value = value;

        }

    }

}
