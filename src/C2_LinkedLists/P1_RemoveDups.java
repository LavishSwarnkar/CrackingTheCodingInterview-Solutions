package C2_LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class P1_RemoveDups {

    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.appendToTail(1, 1);
        System.out.println(list);
        System.out.println(removeDups2(list));
    }

    private static LinkedList removeDups(LinkedList list){
        List<Integer> nodesSeen = new ArrayList<>();

        LinkedList.Node node = list.head
                , previousNode = list.head;

        while (node != null){
            if(nodesSeen.contains(node.data))
                previousNode.next = node.next;
            else
                nodesSeen.add(node.data);

            previousNode = node;
            node = node.next;
        }

        return list;
    }

    //No Temporary Buffer allowed
    private static LinkedList removeDups2(LinkedList list){
        LinkedList.Node current = list.head, finder;
        while (current != null){
            finder = current;
            while (finder.next != null){
                if (finder.next.data == current.data)
                    finder.next = finder.next.next;
                else
                    finder = finder.next;
            }
            current = current.next;
        }
        return list;
    }

}
