package DataStructures.DynamicArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DynamicArray<E> implements Iterable<E>{
    private static final int DEFAULT_CAPACITY = 16;

    private int capcity;        //存储容量的大小
    private int size;           //已经存储元素的大小
    private Object[] elements;  //存放的数据


    public DynamicArray(final int capcity) {
        this.size = 0;
        this.capcity = capcity;
        this.elements = new Object[this.capcity];
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 获取数组下标的元素
     * @param index
     * @return
     */
    public E get(final int index) {
        return this.getElement(index);
    }

    /**
     * 向数组末尾添加元素
     * @param element
     */
    public void add(final E element) {
        //如果当前数组元素存储已满，则扩容为原来的数组的容量的两倍
        if(this.size == this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, newCapactity(2 * this.size));
        }
        this.elements[this.size] = element;
        this.size ++;
    }

    /**
     * 修改数组中下标为index的元素
     * @param index
     * @param element
     */
    public void put(final int index, E element) {
        this.elements[index] = element;
    }

    /**
     * 删除数组中的元素
     * @param index
     * @return
     */
    public E remove(final int index) {
        final E oldElement = getElement(index);
        fastRemove(this.elements,index);

        if(this.capcity > DEFAULT_CAPACITY && size * 4 <= this.capcity) {
            this.elements = Arrays.copyOf(elements,newCapactity(this.capcity / 2));
        }
        return oldElement;
    }

    private void fastRemove(final Object[] elements, final int index) {
        final int newSize = this.size - 1;
        if(newSize > index) {
            System.arraycopy(elements, index + 1, elements, index, newSize - index);
        }
        elements[this.size = newSize] = null;
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
