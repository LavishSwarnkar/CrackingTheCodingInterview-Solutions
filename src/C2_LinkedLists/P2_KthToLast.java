package C2_LinkedLists;

import C2_LinkedLists.LinkedList.Node;

public class P2_KthToLast {

    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.appendToTail(5, 4, 3, 2, 1);
        System.out.println(list);
        System.out.println(getKthToLastOf_4(list.head, 3).data);
    }

    //Iterative Approach: Use two pointers with same gap as k
    private static Node getKthToLastOf_4(Node head, int k){
        if(head == null)
            return null;

        Node p1 = head, p2 = head;
        for(int i=1 ; i<k ; i++){
            if(p2.next == null)
                return null;
            p2 = p2.next;
        }

        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    //Recursive Approach 2: Using wrapper class, return node
    static class Index{
        int value = 0;
    }

    private static Node getKthToLastOf_3(Node head, int k){
        Index index = new Index();
        return getKthToLastOf_3(head, k, index);
    }

    private static Node getKthToLastOf_3(Node head, int k, Index index){
        if (head == null)
            return null;
        Node node = getKthToLastOf_3(head.next, k, index);
        index.value++;
        if(index.value == k)
            return head;
        return node;
    }

    //Recursive Approach 1: Print node
    private static int getKthToLastOf_2(Node head, int k) {
        if (head == null)
            return 0;

        int index = getKthToLastOf_2(head.next, k) + 1;
        if (index == k)
            System.out.println(k + "th to last node is " + head.data);

        return index;
    }

    //Approach 1: Calculate Length and then iterate through list
    private static int getKthToLastOf_1(LinkedList list, int k){
        Node node = list.head;
        if(node == null)
            return -1;

        int count = getListLength(list) - k;
        if(count < 0)
            return -1;

        node = list.head;
        while (node != null){
            if(count-- == 0)
                return node.data;
            node = node.next;
        }

        return -1;
    }

    private static int getListLength(LinkedList list){
        LinkedList.Node node = list.head;
        int count = 1;
        while (node.next != null){
            count++;
            node = node.next;
        }
        return count;
    }

}
