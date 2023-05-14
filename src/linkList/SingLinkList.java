package linkList;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * SingLinkList
 * @author chen
 * @date 2023/5/5 14:10
 * @version 1.0
 */
public class SingLinkList implements Iterable<Integer>{
    private Node head=null;//头指针

    /**
     * 节点类
     */
    private static class Node{
        int value;//值
        Node next;//下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 头部添加
     * @param value
     */
    public void addFirst(int value){
        //1.链表为空
        //head = new Node(value,null);
        //2.链表不为空
        head = new Node(value,head);
    }

    /**
     * 尾部添加
     * @param value
     */
    public void addLast(int value) {
        Node pointer = findLast();
        if(pointer==null){
            addFirst(value);
            return;
        }
        pointer.next = new Node(value,null);
    }

    /**
     * 指定索引位置插入
     * @param index
     * @param value
     */
    public void insert(int index,int value){
        if (index==0){
            addFirst(value);
            return;
        }
        Node node = findNode(index-1);
        if(node==null){
            throw new IllegalArgumentException(
                    String.format("index[%d]不合法%n",index));
        }
        node.next = new Node(value,node.next);
    }

    /**
     * 查找链表尾部
     * @return
     */
    private Node findLast() {
        if (this.head == null) {
            return null;
        }
        Node curr;
        for (curr = this.head; curr.next != null; ) {
            curr = curr.next;
        }
        return curr;
    }

    /**
     * 删除头结点
     */
    public void removeFirst(){
        if(head==null){
            throw new IllegalArgumentException(
                    String.format("链表为空%n"));
        }
        head = head.next;
    }

    /**
     * 根据索引删除指定节点
     * @param index
     */
    public void remove(int index){
        if(index==0){
            removeFirst();
            return;
        }
        Node node = findNode(index-1);
        if(node==null || node.next==null){
            throw new IllegalArgumentException(
                    String.format("index[%d]不合法%n",index));
        }
        node.next = node.next.next;
    }

    /**
     * 根据索引查找
     * @param index
     * @return
     */
    private Node findNode(int index){
        int i =0;
        for (Node p = head;p!=null;p=p.next,i++){
            if(i==index){
                return p;
            }
        }
        return null;
    }

    public int get(int index){
        Node node = findNode(index);
        if(node ==null){
            throw new IllegalArgumentException(
                    String.format("index[%d]不合法%n",index));
        }
        return node.value;
    }

    /**
     * While循环实现遍历链表
     * @param consumer
     */
    public void loop1(Consumer<Integer> consumer){
        Node pointer = head;
        while(pointer!=null){
            consumer.accept(pointer.value);
            pointer = pointer.next;
        }
    }

    /**
     * For循环实现遍历链表
     * @param consumer
     */
    public void loop2(Consumer<Integer> consumer){
        for(Node p=head;p!=null;p=p.next){
            consumer.accept(p.value);
        }
    }

    /**
     * 递归遍历
     */
    public void loop3(){
        recursion(head);
    }
    private void recursion(Node curr){//针对某个节点的操作
        if(curr==null){
            return;
        }
        System.out.println(curr.value);
        recursion(curr.next);
    }

    /**
     * 迭代器遍历链表
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        //匿名内部类
        return new Iterator<Integer>() {
            Node pointer = head;
            @Override
            public boolean hasNext() {
                return pointer!=null;
            }

            @Override
            public Integer next() {
                int v = pointer.value;
                pointer = pointer.next;
                return v;
            }
        };
    }

}

