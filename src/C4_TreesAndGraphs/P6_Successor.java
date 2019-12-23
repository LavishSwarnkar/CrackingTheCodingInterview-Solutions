package C4_TreesAndGraphs;

import javafx.util.Pair;

public class P6_Successor {

    public static void main(String args[]){
        BinaryTree n2 = new BinaryTree(2)
                , n1 = new BinaryTree(1)
                , n4 = new BinaryTree(4)
                , n7 = new BinaryTree(7);
        n1.setRightSubtree(n4);
        n2.setLeftSubtree(n1);
        n2.setRightSubtree(n7);
        n4.parent = n1;
        n1.parent = n2;
        n7.parent = n2;

        System.out.println(getSuccessor(n1));
        System.out.println(getSuccessor(n2));
        System.out.println(getSuccessor(n7));
    }

    private static BinaryTree getSuccessor(BinaryTree tree){
        if(tree == null)
            return null;
        if(tree.rightSubtree != null)
            return getLeftmostChild(tree.rightSubtree);
        BinaryTree curr = tree
                , parent = tree.parent;
        while (parent != null && parent.leftSubtree != curr){
            curr = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private static BinaryTree getLeftmostChild(BinaryTree tree) {
        if(tree == null)
            return null;
        while (tree.leftSubtree != null)
            tree = tree.leftSubtree;
        return tree;
    }

}
