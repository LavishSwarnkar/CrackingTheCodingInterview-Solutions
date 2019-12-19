package C2_LinkedLists;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedList {

    Node head = null;

    void appendToTail(int... n){
        for(int i : n){
            Node newNode = new Node(i);
            if(head == null) {
                head = newNode;
            }else {
                Node node = head;
                while (node.next != null)
                    node = node.next;
                node.next = newNode;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node node = head;

        while (node != null){
            builder.append(node.data)
                    .append("->");
            node = node.next;
        }

        String s = builder.toString();
        return s.length() > 0 ? s.substring(0, s.lastIndexOf("->")) : s;
    }

    public static class Node{
        Node next = null;
        int data;

        Node(int data){
            this.data = data;
        }
    }

}
