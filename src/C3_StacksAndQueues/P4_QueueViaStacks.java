package C3_StacksAndQueues;

public class P4_QueueViaStacks {

    public static void main(String args[]){
        MyQueue queue = new MyQueue();

        System.out.println("Enqueuing 1, 2,...,5 : ");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.print();

        queue.dequeue();
        System.out.println("Dequeuing once : ");
        queue.print();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("Dequeuing thrice : ");
        queue.print();

        queue.dequeue();
        System.out.println("Dequeuing once : ");
        queue.print();
    }

    private static class MyQueue{

        private static Stack stack1 = new Stack()
                , stack2 = new Stack();
        private static final int ENQUEUE = 1, DEQUEUE = 2;
        private int previousOperation = ENQUEUE;

        void enqueue(int x){
            if(previousOperation != ENQUEUE){
                reverseCopy2to1();
                previousOperation = ENQUEUE;
            }
            stack1.push(x);
        }

        void dequeue(){
            if(previousOperation != DEQUEUE){
                reverseCopy1to2();
                previousOperation = DEQUEUE;
            }
            stack2.pop();
        }

        private void reverseCopy1to2(){
            stack2.top = null;
            IntNode node = stack1.top;
            while (node != null){
                stack2.push(node.data);
                node = node.next;
            }
        }

        private void reverseCopy2to1(){
            stack1.top = null;
            IntNode node = stack2.top;
            while (node != null){
                stack1.push(node.data);
                node = node.next;
            }
        }

        void print(){
            if(previousOperation != DEQUEUE){
                reverseCopy1to2();
                previousOperation = DEQUEUE;
            }
            System.out.print("Start->");
            IntNode node = stack2.top;
            while (node != null){
                System.out.print(node.data + (node.next == null ? "" : "->"));
                node = node.next;
            }
            System.out.println();
            System.out.println();
        }

    }

}
