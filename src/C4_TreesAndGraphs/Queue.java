package C4_TreesAndGraphs;

import C3_StacksAndQueues.Node;

import java.util.EmptyStackException;

public class Queue<T> {

    private Node<T> start, end;

    void enqueue(T graphNode){
        Node<T> node = new Node<>(graphNode);
        if(start == null){
            start = end = node;
        } else {
            end.next = node;
            end = node;
        }
    }

    T dequeue(){
        if(start == null){
            throw new EmptyStackException();
        } else {
            T startNode = start.data;
            start = start.next;
            return startNode;
        }
    }

    T peek(){
        if(start == null)
            throw new EmptyStackException();
        else
            return start.data;
    }

    boolean isEmpty(){
        return start == null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Start -> ");
        if(isEmpty())
            return builder.append(" NULL <- End").toString();
        Node<T> node = start;
        while (node != null){
            builder.append(node.data);
            if(node.next != null)
                builder.append("->");
            node = node.next;
        }
        return builder.append(" <- End").toString();
    }
}
