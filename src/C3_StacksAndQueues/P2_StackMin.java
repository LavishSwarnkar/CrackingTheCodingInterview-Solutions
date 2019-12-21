package C3_StacksAndQueues;

import java.util.EmptyStackException;

public class P2_StackMin {

    private static IntNode top, min;

    public static void main(String args[]){
        push(5);
        push(10);
        System.out.println("Pushing 5, then 10...");
        print();

        push(1);
        System.out.println("Pushing 1...");
        print();

        push(2);
        push(0);
        System.out.println("Pushing 2, then 0...");
        print();

        pop();
        System.out.println("Popping 0...");
        print();

        pop();
        pop();
        System.out.println("Popping 2, then 1...");
        print();
    }

    private static void push(int x){
        IntNode node = new IntNode(x);
        node.next = top;
        top = node;

        if(min == null) {
            min = new IntNode(x);
        } else if(node.data < min.data){
            IntNode newMinNode = new IntNode(x);
            newMinNode.next = min;
            min = newMinNode;
        }
    }

    private static void pop(){
        if(top == null) {
            throw new EmptyStackException();
        } else {
            if(top.data == min.data)
                min = min.next;
            top = top.next;
        }
    }

    private static IntNode min(){
        if(top == null)
            throw new EmptyStackException();
        else
            return min;
    }

    private static void print(){
        System.out.print("top->");

        IntNode node = top;
        while (node != null){
            System.out.print(node.data + (node.next == null ? "" : "->"));
            node = node.next;
        }

        System.out.println("  |  min->" + (min == null ? "" : min.data));
        System.out.println();
    }

}
