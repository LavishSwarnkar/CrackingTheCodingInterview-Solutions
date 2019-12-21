package C3_StacksAndQueues;

public class IntNode {
    IntNode next = null;
    int data;

    IntNode(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
