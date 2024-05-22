package org.zane.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Consumer;

/*
LinkedList data is not continuous, so there is no index like array

可以說linkedList 跟array 最大的差別就是linkedList 不會有一個container去裝element,
element之間只有透過pointer 做連結，這也就是為什麼linkedList is not continuous

 */
public class SinglyLinkedList<T> {

    private Node<T> head;

    /*
    inner class
    因為node 要依附linkedList 才有意義 所以設計成inner class
     */
    /*
    什麼時候inner class 應該加上static?
    如果 inner class 沒有使用outer class fields, 就可以加上static
    (理解：如果inner class is static, 代表所有的inner class 都共用相同的值，
    但是outer class field 不是static, 代表each instance of outer class has different field value,
    這樣邏輯就不通順了)

    能用static 就用static
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Node<T> {
        private T value;
        private Node<T> next;
    }


    public void addFirst(T element) {
        // list is empty
//        head = new Node<T>(element,null);

        // list is not empty, the next should point to the previous head element
//        head = new Node<T>(element,head);

        /*
        因為linkedList is empty的時候，head = null
        所以可以直接只使用  head = new Node<T>(element,head); 來處理兩種情況
         */
        head = new Node<T>(element, head);

    }

    public void traverse(Consumer<T> consumer) {
//       從head 開始遍歷
        Node<T> node = head;

        while (node.next != null) {
            consumer.accept(node.value);

            // assign the original node to the next node
            node = node.next;
        }
    }

    private Node<T> getLastNode() {
        // if head is null, which mean the linkedList is null
        if (head == null) {
            return null;
        }

        Node<T> node = head;

        // when node.next == null, it would break out the loop
        while (node.next != null) {
            node = node.next;
        }

        return node;
    }

    public void addLast(T element) {
        Node<T> lastNode = getLastNode();

        // lastNode == null, which mean the linkedList is null
        if (lastNode == null) {
//            head = new Node<T>(element,null);
            addFirst(element);
        } else {
            // the linkedList is not null
            lastNode.next = new Node<T>(element, null);
        }
    }

    /*
    get value based on index

    but linkedList is not continuous, it does not use array, so it does not have the original index;
    so it through traverse to get the index.
    but there is no field of node to store the index value,
    because when add or remove the element, the index of element would change, it is hard to maintain,
    and it would become more and more like array
     */
    public Node<T> getNodeByIndex(int index) {
        /*
        need to traverse, so the initial value of temp node is head
         */
        Node<T> node = head;

        // the LinkedList is null
        if (node == null) {
            return null;
        }


        // create the variable i to be temporary index, but do not store the index value in the node
        int i = 0;
        while (node.next != null) {
            if (i == index) {
                return node;
            }

            node = node.next;
            i++;


        }

        return null; // if index > size, which also mean the while loop would break out(the loop continues
        // to the last element), so it should return null here
    }

    public void insertByIndex(T element, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index should not be negative");
        } else if (index == 0) {
            addFirst(element);
        } else {
            // index > 0
            Node<T> previousNode = getNodeByIndex(index - 1);

            if (previousNode == null) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }

            previousNode.next = new Node<T>(element, previousNode.next);
        }

    }

    public Node<T> removeFirst() {
        if (head == null) {
            return null;
        }
        Node<T> node = head;

        head = head.next;

        return node;
    }

    /*
    LinkedList element 之間只靠pointer連結，所以只要改pointer就好
     */
    public Node<T> removeByIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index should not be negative");
        } else if (index == 0) {
            return removeFirst();
        } else {
            Node<T> previousNode = getNodeByIndex(index - 1);

            if (previousNode == null || previousNode.next == null) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }

            previousNode.next = previousNode.next.next;

            return previousNode.next;
        }
    }
}
