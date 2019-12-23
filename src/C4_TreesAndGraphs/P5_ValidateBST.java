package C4_TreesAndGraphs;

public class P5_ValidateBST {

    public static void main(String args[]){
        BinaryTree n2 = new BinaryTree(3)
                , n1 = new BinaryTree(3)
                , n4 = new BinaryTree(3);
        //n1.setRightSubtree(n4);
        n2.setLeftSubtree(n1);
        System.out.println(isBST(n2, Integer.MIN_VALUE, Integer.MAX_VALUE));;
    }

    private static boolean isBST(BinaryTree tree, int min, int max) {
        return tree == null
                || ((tree.data > min && tree.data <= max)
                    && isBST(tree.leftSubtree, min, tree.data)
                    && isBST(tree.rightSubtree, tree.data, max));
    }

}
