package Deque;

/**
 * Deque 双端队列
 * @author chen
 * @date 2023/5/10 15:32
 * @version 1.0
 */
public interface Deque<E> {
    boolean offerFirst(E e);

    boolean offerLast(E e);

    E pollFirst();

    E pollLast();

    E peekFirst();

    E peekLast();

    boolean isEmpty();

    boolean isFull();
}
