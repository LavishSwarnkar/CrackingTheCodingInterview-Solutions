package C3_StacksAndQueues;

import java.util.EmptyStackException;

public class Queue{

    IntNode start, end;

    void enqueue(int x){
        IntNode node = new IntNode(x);
        if(start == null){
            start = end = node;
        } else {
            end.next = node;
            end = node;
        }
    }

    void dequeue(){
        if(start == null)
            throw new EmptyStackException();
        else
            start = start.next;
    }

}
