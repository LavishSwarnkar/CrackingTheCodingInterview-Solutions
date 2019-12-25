package C4_TreesAndGraphs;

public class P10_CheckSubtree {

    public static void main(String args[]){
        BinaryTree n0 = new BinaryTree(0)
                , n = new BinaryTree(-1)
                , n1 = new BinaryTree(1)
                , n2 = new BinaryTree(2)
                , n3 = new BinaryTree(3)
                , n6 = new BinaryTree(6)
                , n5 = new BinaryTree(5)
                , n3clone = new BinaryTree(3);
        n3.setRightSubtree(n5);
        n3clone.setRightSubtree(n5);
        n5.setRightSubtree(n6);
        n2.setLeftSubtree(n1);
        n2.setRightSubtree(n3);
        n0.setLeftSubtree(n);
        n0.setRightSubtree(n2);

        System.out.println(isSubTree(n0, n3clone));
        System.out.println(isSubTree(n0, new BinaryTree(32)));
    }

    private static boolean isSubTree(BinaryTree t1, BinaryTree t2) {
        if(t1 == null)
            return false;
        return areIdentical(t1, t2)
                || isSubTree(t1.leftSubtree, t2)
                || isSubTree(t1.rightSubtree, t2);
    }

    private static boolean areIdentical(BinaryTree t1, BinaryTree t2) {
        return (t1 == null && t2 == null)
                || ((t1 != null && t2 != null)
                    && t1.data == t2.data
                    && areIdentical(t1.leftSubtree, t2.leftSubtree)
                    && areIdentical(t1.rightSubtree, t2.rightSubtree));
    }

}
