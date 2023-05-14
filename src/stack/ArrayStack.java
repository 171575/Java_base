package stack;

import java.util.Iterator;

/**
 * ArrayStack
 * @author chen
 * @date 2023/5/10 14:31
 * @version 1.0
 */
public class ArrayStack<E> implements Stack<E>,Iterable<E>{
    private final E[] array;
    private int top;

    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if(isEmpty()){
            return false;
        }
        array[top++]=value;
        return true;
    }

    @Override
    public E pop() {
        if(isFull()){
            return null;
        }
        E value = array[--top];
        return value;
    }

    @Override
    public E peek() {
        if(isFull()){
            return null;
        }
        E value = array[top-1];
        return value;
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }

    @Override
    public boolean isFull() {
        return top==array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = top;
            @Override
            public boolean hasNext() {
                return p > 0;
            }

            @Override
            public E next() {
                E value=array[--p];
                return value;
            }
        };
    }
}
 