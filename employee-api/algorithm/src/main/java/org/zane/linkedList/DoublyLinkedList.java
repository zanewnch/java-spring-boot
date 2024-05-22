package org.zane.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.InvalidParameterException;
import java.util.function.Consumer;

/*
The advantage of doubly linkedList is 進行反向操作的時候  會更方便
 */
@Data
public class DoublyLinkedList<T> {

    private final Node<T> head;
    private final Node<T> tail;
    private int size;

    public DoublyLinkedList(){
        this.head = new Node<>(null,null,null);
        this.tail = new Node<>(null,this.head,null);
        this.size = 0;

        // in the same class, can directly access private field without get method
        // 因為initialize的時候,tail 還沒有被initialize, 所以要在initialize tail 之後再把head.next 指向tail
        this.head.next = this.tail;


    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Node<T>{
        private T value;
        private Node<T> prev;
        private Node<T> next;
    }

    public Node<T> getNode(int index){

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> node = head.next;
        int i = 0;

        /*
        為了不要讓node 走到tail, 所以用node != tail

        如果用原本的while(node.next != null), 會有可能走到tail
         */
        while(node != tail){
            if(i == index){
                return node;
            }else{
                node = node.next;
                i++;
            }
        }

        return null;
    }

    public void add(T element, int index){
        if(index < 0 || index > size){
            throw new InvalidParameterException("Invalid index");
        }

        Node<T> prevNode = getNode(index - 1);

        prevNode.next = new Node<T>(element,prevNode,prevNode.next);
        prevNode.next.next.prev = prevNode.next;

        size++;
    }

    public Node<T> remove(int index){
        if(index < 0 || index > size){
            throw new InvalidParameterException("Invalid index");
        }

        Node<T> prevNode = getNode(index - 1);
        Node<T> currentNode = prevNode.next;

        prevNode.next = prevNode.next.next;
        prevNode.next.prev = prevNode;

        size--;

        return currentNode;
    }

    public void traverse(Consumer<T> consumer){
        Node<T> node = head.next;

        while (node != tail){
            consumer.accept(node.value);
            node = node.next;
        }
    }

}
