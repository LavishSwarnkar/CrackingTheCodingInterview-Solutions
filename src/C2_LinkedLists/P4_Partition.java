package C2_LinkedLists;

import C2_LinkedLists.LinkedList.Node;

public class P4_Partition {

    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.appendToTail(3, 5, 8, 5, 10, 2, 1);
        System.out.println(list);

        System.out.println(partition(list, 5));
    }

    //Author'sSolution
    private static LinkedList partition2(LinkedList list, int x){
        Node head, tail, node;
        head = tail = node = list.head;

        while(node != null){
            Node next = node.next;
            if(node.data < x){
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        list.head = head;

        return list;
    }

    //MySolution
    private static LinkedList partition(LinkedList list, int x){
        if (list.head == null || list.head.next == null)
            return list;

        Node node = list.head
                , previousNode = list.head;
        while(node != null){
            if(node != list.head && node.data < x){
                Node newNode = new Node(node.data);
                newNode.next = list.head;
                list.head = newNode;

                previousNode.next = node.next;
            } else {
                previousNode = node;
            }
            node = node.next;
        }

        return list;
    }

}
