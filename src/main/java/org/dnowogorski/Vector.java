package org.dnowogorski;

class Vector<T> {
    private static final int INITIAL_CAPACITY = 16;
    private Object[] array;
    private int size;
    private int capacity;

    Vector() {
        this(INITIAL_CAPACITY);
    }

    Vector(int initialCapacity) {
        array = new Object[initialCapacity];
        size = 0;
        capacity = initialCapacity;
    }

    int size() {
        return size;
    }

    int capacity() {
        return capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void push(T newElement) {
        if (isCapacityExceeded()) resize();
        array[size++] = newElement;
    }

    void insert(T newElement, int index) {
        verifyBoudaries(index);
        if (isCapacityExceeded()) resize();
        shiftRight(index);
        array[index] = newElement;
    }

    T pop() {
        T element = at(size - 1);
        array[size - 1] = null;
        size--;
        return element;
    }

    @SuppressWarnings("unchecked")
    T at(int index) {
        verifyBoudaries(index);
        return (T) array[index];
    }

    int find(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) return i;
        }
        return -1;
    }

    void delete(int index) {
        verifyBoudaries(index);
        shiftLeft(index);
        size--;
    }

    void remove(T element) {
        int indexToRemove = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) indexToRemove = i;
        }
        if (indexToRemove != -1) delete(indexToRemove);
    }

    void verifyBoudaries(int index) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException(index);
    }

    private boolean isCapacityExceeded() {
        return size + 1 > capacity;
    }

    private void resize() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    private void shiftRight(int from) {
        System.arraycopy(array, from, array, from + 1, size - from);
    }

    private void shiftLeft(int from) {
        System.arraycopy(array, from, array, from - 1, size - from);
    }
}
