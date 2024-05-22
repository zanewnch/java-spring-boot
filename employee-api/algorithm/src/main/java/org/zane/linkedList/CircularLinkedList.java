package org.zane.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.InvalidParameterException;
import java.util.function.Consumer;

/*
一般情况下，常规的单链表（Singly Linked List）会提供额外的 addFirst 和 addLast 方法，以使链表的头部和尾部插入元素变得更加方便。
 */

/*
這個class 的methods name 都是common and necessary
 */
@Data
public class CircularLinkedList<T> {
    private final Node<T> head;
    private final Node<T> tail;
    private int size;

    public CircularLinkedList() {
        this.head = new Node<>(null, null, null);
        this.tail = new Node<>(null, this.head, this.head);
        this.size = 0;

        this.head.next = this.tail;
        this.head.prev = this.tail;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Node<T> {
        private T value;
        private Node<T> prev;
        private Node<T> next;
    }

    public void indexCheck(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidParameterException("Invalid index");
        }
    }

    public Node<T> get(int index) {
        indexCheck(index);

        Node<T> node = head.next;

        int i = 0;
        while (node != tail) {
            if (i == index) {
                return node;
            } else {
                node = node.next;
                i++;
            }
        }

        return null;
    }

    public void addFirst(T element) {
        head.next = new Node<>(element, head, head.next);
    }

    public void addLast(T element) {

        // 這個方式是正確的但不會這樣用
        // 減3是因為，一個是index, 一個是tail sentinel node, 再一個是prev node
//        Node<T> prevNode = get(size - 1 -1 - 1 );
//        prevNode.next = new Node<>(element, prevNode, prevNode.next);

        // 有tail 就直接用tail
        tail.prev.next = new Node<>(element, tail.prev, tail);

    }

    public void insertAt(T element, int index) {
        indexCheck(index);

        Node<T> prevNode = get(index - 1);
        Node<T> node = new Node<>(element, prevNode, prevNode.next);

        prevNode.next = node;
        node.next.prev = node;
    }

    public Node<T> removeFirst() {
        // which mean the actual list is empty
        if (head.next == tail) {
            return null;
        }

        Node<T> node = head.next;
        head.next = node.next;
        node.next.prev = head;

        return node;
    }

    public Node<T> removeLast() {
        if (head.next == tail) {
            return null;
        }

        Node<T> prevNode = tail.prev.prev;
        Node<T> node = tail.prev;

        prevNode.next = tail;
        tail.prev = prevNode;

        return node;
    }

    public Node<T> removeAt(int index) {
        indexCheck(index);

        Node<T> prevNode = get(index - 1);
        Node<T> node = prevNode.next;

        prevNode.next = node.next;
        node.next.prev = prevNode;

        return node;
    }

    public void traverse(Consumer<T> consumer) {
        Node<T> node = head.next;

        while (node != tail) {
            consumer.accept(node.value);
            node = node.next;
        }
    }

    public void traverseByRecursion(Node<T> node, Consumer<T> consumer) {
        /*
        因為最後一個element一定是tail, 所以不會有node.next == null 的情況發生
         */
        if (node == tail) {
            return;
        }

        consumer.accept(node.value);
        traverseByRecursion(node.next, consumer);
    }

}
