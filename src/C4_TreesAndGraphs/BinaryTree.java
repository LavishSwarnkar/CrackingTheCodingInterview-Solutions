package C4_TreesAndGraphs;

class BinaryTree {

    int data;
    BinaryTree leftSubtree, rightSubtree;

    BinaryTree(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(leftSubtree == null ? "" : leftSubtree);
        builder.append(data).append(" ");
        builder.append(rightSubtree == null ? "" : rightSubtree);
        return builder.toString();
    }

    public BinaryTree setLeftSubtree(BinaryTree leftSubtree) {
        this.leftSubtree = leftSubtree;
        return this;
    }

    public BinaryTree setRightSubtree(BinaryTree rightSubtree) {
        this.rightSubtree = rightSubtree;
        return this;
    }
}
