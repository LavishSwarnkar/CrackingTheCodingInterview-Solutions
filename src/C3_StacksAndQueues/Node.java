package C3_StacksAndQueues;

public class Node<T> {
    Node<T> next = null;
    T data;

    Node(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
