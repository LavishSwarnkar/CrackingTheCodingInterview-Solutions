package C4_TreesAndGraphs;

public class P4_CheckBalanced {

    public static void main(String args[]){
        BinaryTree n1 = new BinaryTree(1)
                , n2 = new BinaryTree(2)
                , n3 = new BinaryTree(3)
                , n4 = new BinaryTree(4)
                , n5 = new BinaryTree(5)
                , n6 = new BinaryTree(6);
        n2.setLeftSubtree(n4);
        //n2.setRightSubtree(n5);
        n3.setRightSubtree(n6);
        n1.setLeftSubtree(n2);
        n1.setRightSubtree(n3);

        System.out.println(isBalanced2(n1));
        //System.out.println(isBalanced(n1).isBalanced);
    }

    private static boolean isBalanced2(BinaryTree tree){
        return getHeight(tree) != Integer.MAX_VALUE;
    }

    private static int getHeight(BinaryTree tree){
        if(tree == null)
            return -1;
        int lHeight = getHeight(tree.leftSubtree)
                , rHeight = getHeight(tree.rightSubtree)
                , diff = Math.abs(lHeight - rHeight);
        if(lHeight == Integer.MAX_VALUE || rHeight == Integer.MAX_VALUE || (diff > 1))
            return Integer.MAX_VALUE;
        return Math.max(lHeight, rHeight) + 1;
    }

    static class Status{
        int weight;
        boolean isBalanced;

        Status(int weight){
            this.weight = weight;
            isBalanced = Math.abs(weight) <= 1;
        }
    }

    private static Status isBalanced(BinaryTree tree){
        if(tree == null)
            return new Status(0);
        else if(tree.leftSubtree == null && tree.rightSubtree == null)
            return new Status(1);
        return new Status(isBalanced(tree.leftSubtree).weight
                - isBalanced(tree.rightSubtree).weight);
    }

}
