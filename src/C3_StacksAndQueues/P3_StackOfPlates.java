package C3_StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class P3_StackOfPlates {

    private static final int STACK_THRESHOLD = 3;
    private static List<IntNode> stacks = new ArrayList<>();
    private static int currStackNo = -1, currStackSize = 0;

    public static void main(String args[]){
        push(1);    push(2);    push(3);
        System.out.println("Pushing 1, 2 and 3");
        print();

        push(4);    push(5);
        System.out.println("Pushing 4 and 5");
        print();

        pop();  pop();
        System.out.println("Popping 4 and 5");
        print();

        pop();
        System.out.println("Popping 3");
        print();

        push(10);   push(11);   push(12);
        push(13);   push(14);   push(15);
        push(16);
        System.out.println("Pushing 10, 11,...,16");
        print();

        popAt(1);
        System.out.println("Popping from Stack #2");
        print();

        popAt(1);
        System.out.println("Popping from Stack #2");
        print();

        popAt(0);
        System.out.println("Popping from Stack #1");
        print();

        popAt(0);
        System.out.println("Popping from Stack #1");
        print();
    }

    private static void push(int x){
        IntNode node = new IntNode(x);
        if(currStackNo == -1 || currStackSize == STACK_THRESHOLD){
            currStackNo++;
            currStackSize = 0;
            stacks.add(node);
        } else {
            node.next = stacks.get(currStackNo);
            stacks.remove(currStackNo);
            stacks.add(currStackNo, node);
        }
        currStackSize++;
    }

    private static void pop(){
        if(currStackSize == 0){
            throw new EmptyStackException();
        } else {
            currStackSize--;
            if(currStackSize == 0){
                stacks.remove(currStackNo);
                currStackNo--;
                if(currStackNo != -1)
                    currStackSize = STACK_THRESHOLD;
            } else {
                IntNode nextTopNode = stacks.get(currStackNo).next;
                stacks.remove(currStackNo);
                stacks.add(currStackNo, nextTopNode);
            }
        }
    }

    private static void popAt(int stackNo){
        if(stackNo >= stacks.size()){
            throw new EmptyStackException();
        } else if(stackNo == stacks.size()-1){
            pop();
        } else {
            for(int i = stackNo; i< stacks.size()-1 ; i++){
                IntNode newTop = removeAndGetTail(i+1);

                if(i == stackNo){
                    IntNode nodeNextToNodeToBePopped = stacks.get(stackNo).next;
                    stacks.remove(stackNo);
                    stacks.add(stackNo, nodeNextToNodeToBePopped);
                }

                newTop.next = stacks.get(i);
                stacks.remove(i);
                stacks.add(i, newTop);
            }
            currStackSize--;
            if(currStackSize == 0){
                stacks.remove(currStackNo--);
                currStackSize = STACK_THRESHOLD;
            }
        }
    }

    private static IntNode removeAndGetTail(int stackNo) {
        IntNode node, prevNode;
        node = prevNode = stacks.get(stackNo);
        while (node.next != null){
            prevNode = node;
            node = node.next;
        }
        prevNode.next = null;
        return node;
    }

    private static void print(){
        if(currStackNo == -1) {
            throw new EmptyStackException();
        } else {
            for(IntNode topNode : stacks){
                System.out.print(getStackString(topNode));
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println();
        }
    }

    private static String getStackString(IntNode node){
        StringBuilder builder = new StringBuilder();
        builder.append("Top->");
        while (node != null){
            builder.append(node.data);
            if(node.next != null)
                builder.append("->");
            node = node.next;
        }
        return builder.toString();
    }

}
