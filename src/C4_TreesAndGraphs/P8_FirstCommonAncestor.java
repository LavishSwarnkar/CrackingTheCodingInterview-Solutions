package C4_TreesAndGraphs;

public class P8_FirstCommonAncestor {

    public static void main(String args[]){
        BinaryTree n1 = new BinaryTree(1)
                , n2 = new BinaryTree(2)
                , n3 = new BinaryTree(3)
                , n4 = new BinaryTree(4)
                , n5 = new BinaryTree(5)
                , n6 = new BinaryTree(6);
        n5.setRightSubtree(n6);
        n3.setLeftSubtree(n4);
        n3.setRightSubtree(n5);
        n1.setLeftSubtree(n2);
        n1.setRightSubtree(n3);

        /*     1
         *    / \
         *   2   3
         *      / \
         *     4   5
         *          \
         *           6
         */

        System.out.println(contains(n1, n4, n6));
        System.out.println(contains(n1, n3, n6));
        System.out.println(contains(n1, n2, n6));
        System.out.println(contains(n1, n3, new BinaryTree(5)));
    }

    private static class Result{
        boolean hasA, hasB;
        BinaryTree firstCommonAncestor;
        Result(boolean hasA, boolean hasB){
            this.hasA = hasA;
            this.hasB = hasB;
        }
        Result(BinaryTree firstCommonAncestor){
            hasA = hasB = true;
            this.firstCommonAncestor = firstCommonAncestor;
        }
        @Override
        public String toString() {
            return firstCommonAncestor == null ? "Not found"
                    : ("firstCommonAncestor = " + firstCommonAncestor.data);
        }
    }

    private static Result contains(BinaryTree tree, BinaryTree a, BinaryTree b){
        if(tree == null)
            return new Result(false, false);
        if(tree == a){
            if(contains(a, b))
                return new Result(a);
            return new Result(true, false);
        }
        if(tree == b){
            if(contains(b, a))
                return new Result(b);
            return new Result(false, true);
        }
        Result leftSubtreeResult = contains(tree.leftSubtree, a, b)
                , rightSubtreeResult = contains(tree.rightSubtree, a, b);
        if(leftSubtreeResult.firstCommonAncestor != null)
            return leftSubtreeResult;
        if(rightSubtreeResult.firstCommonAncestor != null)
            return rightSubtreeResult;
        if((leftSubtreeResult.hasA && rightSubtreeResult.hasB)
                || (leftSubtreeResult.hasB && rightSubtreeResult.hasA))
            return new Result(tree);
        return new Result(leftSubtreeResult.hasA || rightSubtreeResult.hasA
                , leftSubtreeResult.hasB || rightSubtreeResult.hasB);
    }

    private static boolean contains(BinaryTree tree, BinaryTree x) {
        return tree != null
                && (tree == x
                    || contains(tree.leftSubtree, x)
                    || contains(tree.rightSubtree, x));
    }

}
