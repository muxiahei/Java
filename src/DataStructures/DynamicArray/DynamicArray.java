package DataStructures.DynamicArray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DynamicArray<E> implements Iterable<E>{
    private static final int DEFAULT_CAPACITY = 16;

    private int capcity;
    private int size;
    private Object[] elements;


    public DynamicArray(final int capcity) {
        this.size = 0;
        this.capcity = capcity;
        this.elements = new Object[this.capcity];
    }

    public DynamicArray() {
        this.capcity = DEFAULT_CAPACITY;
    }

    public void add(final E element) {
        if(this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, newCapactity(2 * this.size));
        }
        this.elements[this.size] = element;
        this.size ++;
    }

    public void put(final int index, E element) {
        this.elements[index] = element;
    }

    public E remove(final int index) {
        final E oldElement = getElement(index);
        return null;
    }

    private void fastRemove(final Object[] elements, final int index) {
        final int newSize = this.size - 1;
        if(newSize > index) {
            System.arraycopy(elements, index + 1, elements, index, newSize - index);
        }
        elements[this.size = newSize] = null;
    }

    public E get(final int index) {
        return this.getElement(index);
    }

    private int newCapactity(int capcity) {
        this.capcity = capcity;
        return this.capcity;
    }

    private E getElement(final int index){
        return (E) this.elements[index];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
}
