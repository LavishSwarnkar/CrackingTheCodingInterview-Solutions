package C3_StacksAndQueues;

public class Node<T> {
    public Node<T> next = null;
    public T data;

    public Node(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
