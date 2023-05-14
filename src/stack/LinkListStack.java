package stack;

import java.util.Iterator;

/**
 * LinkListStack
 * @author chen
 * @date 2023/5/10 11:00
 * @version 1.0
 */
public class LinkListStack <E> implements Stack<E>,Iterable<E>{
    private int capacity;
    private int size;
    private Node<E> head=new Node<>(null,null);
    static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
    public LinkListStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean push(E value) {
        if(isFull()){
            return false;
        }
        Node node = new Node<>(value, head.next);
        head.next= node;
        size++;
        return false;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        Node<E> next = head.next;
        head.next=next.next;
        size--;
        return next.value;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        Node<E> next = head.next;
        return next.value;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p=head.next;
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public E next() {
                E value = p.value;
                p=p.next;
                return value;
            }
        };
    }
}
 