package C2_LinkedLists;

import C2_LinkedLists.LinkedList.Node;

import java.util.Stack;

public class P6_Palindrome {

    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.appendToTail(1, 2, 3, 2, 1);
        System.out.println(list);
        System.out.println(isPalindrome3(list));
    }

    //Approach 3 : Recursion
    private static boolean isPalindrome3(LinkedList list){
        return isPalindromeRecurse(list.head, lengthOfList(list.head)).res;
    }

    private static Result isPalindromeRecurse(Node head, int length){
        if(head == null || length <= 0)
            return new Result(head, true);
        else if (length == 1)
            return new Result(head.next, true);

        Result result = isPalindromeRecurse(head.next, length - 2);

        if (!result.res || result.node == null)
            return result;

        result.res = (head.data == result.node.data);
        result.node = result.node.next;
        return result;
    }

    private static class Result{
        private Node node;
        private boolean res;

        Result(Node node, boolean res) {
            this.node = node;
            this.res = res;
        }
    }

    private static int lengthOfList(Node n) {
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    //Approach 2 : Iterative using Stack
    private static boolean isPalindrome2(LinkedList list){
        Node fast, slow;
        fast = slow = list.head;

        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null)
            slow = slow.next;

        while (slow != null){
            int x = stack.pop();
            if(x != slow.data)
                return false;
            slow = slow.next;
        }
        return true;
    }

    //Approach 1 : Reverse And Compare
    private static boolean isPalindrome(LinkedList list){
        LinkedList reversedList = reverseList(list);
        Node n1 = list.head
                , n2 = reversedList.head;
        while (n1 != null && n2 != null){
            if(n1.data != n2.data)
                return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }

    private static LinkedList reverseList(LinkedList list){
        LinkedList reversedList = new LinkedList();
        Node node = list.head;
        while (node != null){
            Node newNode = new Node(node.data);
            newNode.next = reversedList.head;
            reversedList.head = newNode;

            node = node.next;
        }
        return reversedList;
    }

}
