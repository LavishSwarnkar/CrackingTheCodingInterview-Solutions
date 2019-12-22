package C4_TreesAndGraphs;

import java.util.*;

public class P3_ListOfDepths {

    private static Map<Integer, LinkedList<BinaryTree>> levelListsMap = new HashMap<>();

    public static void main(String args[]){
        BinaryTree n9 = new BinaryTree(9)
                , n8 = new BinaryTree(8)
                , n7 = new BinaryTree(7)
                , n6 = new BinaryTree(6)
                , n5 = new BinaryTree(5)
                , n4 = new BinaryTree(4)
                , n3 = new BinaryTree(3)
                , n2 = new BinaryTree(2)
                , n1 = new BinaryTree(1);
        n8.setLeftSubtree(n9);
        n4.setLeftSubtree(n8);
        n2.setLeftSubtree(n4);
        n2.setRightSubtree(n5);
        n3.setLeftSubtree(n6);
        n3.setRightSubtree(n7);
        n1.setLeftSubtree(n2);
        n1.setRightSubtree(n3);

        dfs(n1, new Level());
        dfs(n1, new Level());
    }

    static class Level{
        int level = -1;
    }

    private static void dfs(BinaryTree tree, Level level){
        if(tree == null)
            return;
        level.level++;
        dfs(tree.leftSubtree, level);
        dfs(tree.rightSubtree, level);
        consume(tree, level);
        level.level--;
    }

    private static void consume(BinaryTree tree, Level level) {
        if(!levelListsMap.containsKey(level.level)){
            LinkedList<BinaryTree> list = new LinkedList<>();
            list.add(tree);
            levelListsMap.put(level.level, list);
        } else {
            levelListsMap.get(level.level).add(tree);
        }
        System.out.print(tree.data + "(" + level.level + ") ");
    }

    List<LinkedList<BinaryTree>> getListOfDepths(BinaryTree tree){
        if(tree == null)
            return null;

        Queue<BinaryTree> queue = new Queue<>();
        queue.enqueue(tree);

        while (!queue.isEmpty()){
            BinaryTree subtree = queue.dequeue();
        }
        return null;
    }

}
