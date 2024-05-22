package org.zane.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.InvalidParameterException;
import java.util.function.Consumer;

/*
summary:
sentinel node: 用來簡化code, 不用特別檢查linkedList 是否為空
以及邊界值的問題
然後head 會直接 initialize 成sentinel node

在manipulate 的時候要注意 temp node 的initialize, 到底要不要包含sentinel node:
Node<T> node = head;
or
Node<T> node = head.next;

如果是 = head, 就代表包含sentinel node, 這樣在manipulate 的時候就不用特別檢查 whether linkedList is empty or not

如果是 = head.next, 就代表不包含sentinel node, 這樣在manipulate 的時候就要特別檢查 whether linkedList is empty or not, 但是最後結果就不用特別剔除sentinel node

要根據condition來決定要不要包含sentinel node(head)

目前只有traverse 不包含sentinel node
 */

public class SinglyLinkedListWithSentinel<T> {
    /*
    The initial value of head is the sentinel node.

    哨兵节点的主要作用是使代码更加一致和可读，而不是将链表从空变成非空。哨兵节点的存在允许你对链表执行相同的操作，而不必担心链表是否为空。这在链表的操作和算法中特别有用，因为它可以简化代码并减少特殊情况的处理。

    : 用了sentinel node, 在manipulate 的時候就不用特別檢查 whether linkedList is empty or not, 因為至少有sentinel node
     */

    /*
    要注意 initialize temp node的時候, 到底要不要包含sentinel node, 也就是
    Node<T> node = head;
    or
    Node<T> node = head.next;
     */
    private Node<T> head = new Node<>(null, null);


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Node<T> {
        private T value;
        private Node<T> next;
    }

    /*
    一旦链表初始化完成，head 引用通常会一直指向 sentinel 节点，而新节点的插入和删除操作都会在 sentinel 节点之后进行。这有助于保持链表的一致性和统一性。
     */
    public void addFirst(T element) {
        head.next = new Node<>(element, head.next);

        /*
        because the sentinel node, it is not necessary to check whether linkedList is empty or not
         */
    }

    public void addLast(T element) {
        Node<T> lastNode = getLastNode();

        lastNode.next = new Node<>(element, null);
    }

    public void traverse(Consumer<T> consumer) {
        /*
        這邊要用head.next, 因為head 是sentinel node, 不是真正的node

        traverse 的時候不需要用到sentinel node
         */
        Node<T> node = head.next;

        while (node != null) {
            consumer.accept(node.value);
            node = node.next;
        }
    }

    public Node<T> getNodeByIndex(int index) {
        Node<T> node = head.next;

        int i = 0;
        while (node.next != null) {
            if (i == index) {
                return node;
            } else {
                node = node.next;
                i++;
            }
        }

        return null;
    }

    public void addByIndex(T element, int index) {

        if (index < 0) {
            throw new InvalidParameterException("index should be greater than 0");
        } else if (index == 0) {
            addFirst(element);
        } else {
            Node<T> prevNode = getNodeByIndex(index - 1);
            prevNode.next = new Node<T>(element, prevNode.next);
        }
    }

    public Node<T> removeFirst() {
        if (head.next == null) {
            return null;
        } else {
            /*
            because the sentinel node, the beginning node is head.next
             */
            head.next = head.next.next;

            return head.next;
        }
    }

    public Node<T> removeByIndex(int index) {
        if (index < 0) {
            throw new InvalidParameterException("index should be greater than 0");
        } else if (index == 0) {
            return removeFirst();
        } else {
            Node<T> prevNode = getNodeByIndex(index - 1);

            if (prevNode == null || prevNode.next == null) {
                throw new InvalidParameterException("index is out of bounds");
            } else {
                prevNode.next = prevNode.next.next;
                return prevNode.next;
            }
        }

    }

    public Node<T> getLastNode() {
        Node<T> node = head;

        while (node.next != null) {
            node = node.next;
        }

        return node;
    }
}
