package C4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2_MinimalTree {

    public static void main(String args[]){
        int[] arr = new int[]{1, 2, 3};
        List<Integer> sortedArray = new ArrayList<>(
                Arrays.asList(1, 2, 10, 12, 20, 25, 30, 40, 50)
        );

        System.out.println(getMinimalBST(sortedArray));
        System.out.println(getMinimalBST2(arr, 0, arr.length - 1));
    }

    /**Author's Solution : Not working as expected as far as I can see.
     * Correct me if I'm wrong.
     */
    private static BinaryTree getMinimalBST2(int[] arr, int start, int end){
        if(end < start)
            return null;
        int mid = (start + end) / 2;
        BinaryTree binaryTree = new BinaryTree(arr[mid]);
        binaryTree.leftSubtree = getMinimalBST2(arr, 0, mid - 1);
        binaryTree.rightSubtree = getMinimalBST2(arr, mid + 1, end);
        return binaryTree;
    }

    //My Solution
    private static BinaryTree getMinimalBST(List<Integer> sortedArray){
        int size = sortedArray.size();
        if(size <= 3){
            BinaryTree binaryTree = new BinaryTree(sortedArray.get(size == 1 ? 0 : 1));
            binaryTree.leftSubtree = new BinaryTree(sortedArray.get(0));
            if(size == 3)
                binaryTree.rightSubtree = new BinaryTree(sortedArray.get(2));
            return binaryTree;
        } else {
            int mid = (int) Math.ceil(size/2f);
            BinaryTree binaryTree = new BinaryTree(sortedArray.get(mid));
            binaryTree.leftSubtree = getMinimalBST(sortedArray.subList(0, mid));
            binaryTree.rightSubtree = getMinimalBST(sortedArray.subList(mid + 1, sortedArray.size()));
            return binaryTree;
        }
    }

}
