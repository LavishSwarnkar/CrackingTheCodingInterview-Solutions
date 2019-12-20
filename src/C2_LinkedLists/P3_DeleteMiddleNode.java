package C2_LinkedLists;

import C2_LinkedLists.LinkedList.Node;

public class P3_DeleteMiddleNode {

    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.appendToTail(5, 4, 3, 2, 1);
        System.out.println(list);

        deleteMiddleNode(list.head.next.next); //Deleting 3

        System.out.println(list);
    }

    private static void deleteMiddleNode(Node node){
        if(node == null || node.next == null)
            return;
        Node nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
    }

}
