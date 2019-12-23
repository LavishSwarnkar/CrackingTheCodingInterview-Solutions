package C4_TreesAndGraphs;

import java.lang.reflect.Array;
import java.util.*;

public class P9_BSTSequence {

    public static void main(String args[]){
        /*BinaryTree n1 = new BinaryTree(1)
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

        System.out.println(getSequences(n1));*/

        /*           0
         *          / \
         *        -1   2
         *            / \
         *           1   3
         *                \
         *                 5
         *                  \
         *                   6
         */

        BinaryTree n0 = new BinaryTree(0)
                , n = new BinaryTree(-1)
                , n1 = new BinaryTree(1)
                , n2 = new BinaryTree(2)
                , n3 = new BinaryTree(3)
                , n6 = new BinaryTree(6)
                , n5 = new BinaryTree(5);
        n3.setRightSubtree(n5);
        n5.setRightSubtree(n6);
        n2.setLeftSubtree(n1);
        n2.setRightSubtree(n3);
        n0.setLeftSubtree(n);
        n0.setRightSubtree(n2);

        ArrayList<ArrayList<Integer>> lists = getSequences(n0);
        System.out.println(lists.toString().replace("], [", "]\n["));
        System.out.print(lists.size());
    }

    private static ArrayList<ArrayList<Integer>> getSequences(BinaryTree tree){
        if(tree == null)
            return new ArrayList<>();
        if(tree.isLeaf()){
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>(Collections.singletonList(tree.data));
            lists.add(list);
            return lists;
        }

        ArrayList<ArrayList<Integer>> leftSequences = getSequences(tree.leftSubtree)
                , rightSequences = getSequences(tree.rightSubtree)
                , newSequences = new ArrayList<>();
        for(List<Integer> leftList : leftSequences)
            for(List<Integer> rightList : rightSequences)
                weave(newSequences, leftList, rightList, new ArrayList<>());

        if(leftSequences.size() == 0)
            return appendToAll(rightSequences, tree.data);
        if(rightSequences.size() == 0)
            return appendToAll(leftSequences, tree.data);
        return appendToAll(newSequences, tree.data);
    }

    private static void weave(ArrayList<ArrayList<Integer>> sequences, List<Integer> list1, List<Integer> list2, List<Integer> prefix) {
        if (list1.size() == 0 || list2.size() == 0){
            ArrayList<Integer> newList = new ArrayList<>(prefix);
            newList.addAll(list1);
            newList.addAll(list2);
            sequences.add(newList);
            return;
        }
        prefix.add(list1.remove(0));
        weave(sequences, list1, list2, prefix);
        list1.add(prefix.remove(prefix.size()-1));
        prefix.add(list2.remove(0));
        weave(sequences, list1, list2, prefix);
        list2.add(prefix.remove(prefix.size()-1));
    }

    private static ArrayList<ArrayList<Integer>> appendToAll(ArrayList<ArrayList<Integer>> lists, int x){
        for(ArrayList<Integer> list : lists){
            list.add(0, x);
        }
        return lists;
    }

}
