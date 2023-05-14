package queue;

import java.util.Iterator;

/**
 * LinkedListQueue
 * @author chen
 * @date 2023/5/9 15:39
 * @version 1.0
 */
public class LinkedListQueue <E> implements Queue<E> ,Iterable<E>{
    private static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
    Node<E> head = new Node<>(null,null);
    Node<E> tail = head;
    private int size =0;
    private int capacity=10;
    {
        tail.next=head;
    }
    public LinkedListQueue(int capacity) {
        this.capacity = capacity;

    }
    public LinkedListQueue(){
    }

    @Override
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        Node<E> added =new Node<>(value,head);
        tail.next=added;
        tail=added;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        head.next=first.next;
        size--;
        if(first==tail){
            tail=head;
        }
        return first.value;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean isFull() {
        return size==capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p != head;
            }
            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
 