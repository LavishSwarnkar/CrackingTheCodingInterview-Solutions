package C3_StacksAndQueues;

public class P5_SortStack {

    public static void main(String args[]){
        Stack stack = new Stack();

        for(int i : new int[]{10, 1, 22, 4, 3, 2})
            stack.push(i);

        System.out.println("Before sorting :");
        System.out.println(stack);

        System.out.println("After sorting :");
        System.out.println(getSortedStack(stack));
    }

    private static Stack getSortedStack(Stack stack) {
        Stack sortedStack = new Stack();

        if(stack.top == null)
            return sortedStack;

        IntNode node = stack.top;
        while (node != null){
            pushToSortedStack(sortedStack, node.data);
            node = node.next;
        }

        return sortedStack;
    }

    private static void pushToSortedStack(Stack stack, int x){
        IntNode newNode = new IntNode(x)
                , node = stack.top;
        if(node == null){
            stack.top = newNode;
        } else {
            if(node.data > x){
                newNode.next = stack.top;
                stack.top = newNode;
            }

            while (node.next != null){
                if(node.next.data > x){
                    newNode.next = node.next;
                    node.next = newNode;
                    return;
                }
                node = node.next;
            }
            node.next = newNode;
        }
    }

}
