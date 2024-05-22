package org.zane.dynamicArray;

/*
size 是指array 裡面非null 的元素
capacity 是指array 裡面可以容納的元素
當DynamicArray<WrapperClass> 的時候, 還沒initialize 就會是null
 */

public class DynamicArray<T> {
    private int size = 0; // the number of elements in the array
    private int capacity = 8; // the number of elements the array can hold
    private T[] array; // the array


    @SuppressWarnings("unchecked")
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        /*
        不會有size > capacity 的情況發生, if size > capacity would throw IndexOutOfBoundsException
         */
        if (size == capacity) {
            capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            System.arraycopy(array, index, newArray, index + 1, size - index);
            array = newArray;
        } else {
            System.arraycopy(array, index, array, index + 1, size - index);
        }


        array[index] = element;
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        T result = array[index];
        // 把element 後面的元素往前移一格
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        // 原本最後一個元素變成null
        array[size - 1] = null;
        size--;

        return result;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return array[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        array[index] = element;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        /*
        return 一個expression, 如果size == 0 就會return true, 如果size != 0 就會return false
         */
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }

        size = 0;
    }


}
