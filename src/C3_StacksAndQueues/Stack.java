package C3_StacksAndQueues;

import java.util.EmptyStackException;

public class Stack {

    IntNode top = null;

    void push(int x){
        IntNode node = new IntNode(x);
        if(top != null)
            node.next = top;
        top = node;
    }

    void pop(){
        if(isEmpty())
            throw new EmptyStackException();
        else
            top = top.next;
    }

    IntNode peek(){
        if(isEmpty())
            throw new EmptyStackException();
        else
            return top;
    }

    boolean isEmpty(){
        return top == null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Top->");

        if(top == null){
            builder.append("NULL");
            return builder.toString();
        }

        IntNode node = top;
        while (node != null){
            builder.append(node.data);
            if(node.next != null)
                builder.append("->");
            node = node.next;
        }

        return builder.toString();
    }
}
