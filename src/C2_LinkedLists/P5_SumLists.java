package C2_LinkedLists;

import C2_LinkedLists.LinkedList.Node;

public class P5_SumLists {

    public static void main(String args[]){
        LinkedList list = new LinkedList()
                , list2 = new LinkedList();
        list.appendToTail(7, 1, 6);
        list2.appendToTail(5, 9, 8, 9);

        System.out.println(getSumList(list, list2));
        System.out.println(getSumListForward(list, list2));
    }

    //MySolution
    private static LinkedList getSumList(LinkedList list, LinkedList list2) {
        LinkedList sumList = new LinkedList();

        Node node1 = list.head
                , node2 = list2.head
                , node3 = sumList.head;

        int carry = 0;
        while (node1 != null || node2 != null){
            int sum = (node1 == null ? 0 : node1.data)
                    + (node2 == null ? 0 : node2.data)
                    + carry;
            carry = sum/10;

            if(node3 == null)
                node3 = sumList.head = new Node(sum%10);
            else
                node3 = node3.next = new Node(sum%10);

            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }

        if(carry > 0)
            node3.next = new Node(carry);

        return sumList;
    }

    //MySolution
    private static LinkedList getSumListForward(LinkedList list, LinkedList list2) {
        LinkedList sumList = new LinkedList();

        Node node1 = list.head
                , node2 = list2.head;

        //S1 : Get numbers represented by the lists
        int n1 = 0, n2 = 0;
        while (node1 != null || node2 != null){
            if(node1 != null)
                n1 = (n1 * 10) + node1.data;
            if(node2 != null)
                n2 = (n2 * 10) + node2.data;

            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }

        //S2 : Add the numbers
        n1 += n2;

        //S3 : Append the digits in the sumList
        while(n1 > 0){
            if(sumList.head == null)
                sumList.head = new Node(n1%10);
            else {
                Node node = new Node(n1%10);
                node.next = sumList.head;
                sumList.head = node;
            }
            n1 /= 10;
        }

        return sumList;
    }

    //Author'sRecursiveSolution
    private static Node getSumList2(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }

        int value = (n1 == null ? 0 : n1.data)
                + (n2 == null ? 0 : n2.data)
                + carry;
        Node result = new Node(value % 10);

        if (n1 != null || n2 != null)
            result.next = getSumList2(n1 == null ? null : n1. next
                    , n2 == null ? null : n2.next
                    , value >= 10 ? 1 : 0);

        return result;
    }

}
