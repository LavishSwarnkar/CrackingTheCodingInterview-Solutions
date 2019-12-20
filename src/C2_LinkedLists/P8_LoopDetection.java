package C2_LinkedLists;

import C2_LinkedLists.LinkedList.Node;

public class P8_LoopDetection {

    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.appendToTail(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Node node = list.head
                , startingNode = new Node(-1);
        while (node.next != null){
            if(node.data == 5)
                startingNode = node;
            node = node.next;
        }
        node.next = startingNode;

        System.out.println(getLoopBeginningNode(list));
    }

    /**INSIGHTS :
     * > Let k be the length of non-loop part
     * > We take one Slow and one Fast pointer. FP goes two steps
     *   for every step that SP takes.
     * > So, when SP reaches start of loop (taken k steps), FP has
     *   taken 2k steps. So, in loop they are 2k-k steps apart.
     * > But for cases where (k > LoopSize), we take this gap as
     *   K = k % LoopSize
     * > Now, for every step taken further, they come closer by
     *   1 step.
     * > So, it will take us (LoopSize - K) steps to reach Collision
     *   Point.
     * > By the equation, k = K + M * LoopSize, taking k steps from
     *   Head and Collision Point at same pace will lead us to Beginning
     *   Point.
     *
     * ALGORITHM :
     * > Move FP & SP until they collide
     * > Move SP to Head and increment both with same pace
     * > Stop when they collide. This is the Beginning Point we need.
     */
    private static Node getLoopBeginningNode(LinkedList list){
        Node fast, slow;
        fast = slow = list.head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
                break;
        }

        if(fast == null || fast.next == null)
            return null;

        slow = list.head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

}
