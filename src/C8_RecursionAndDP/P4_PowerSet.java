package C8_RecursionAndDP;

import java.util.*;

public class P4_PowerSet {

    public static void main(String args[]){
        //System.out.println(getPowerSet(new ArrayList<>(Arrays.asList(1, 2, 3)), 0));
        getPowerSet(new ArrayList<>(Arrays.asList(1, 2, 3)), 0);
        System.out.println();
    }

    //Efficient solution inspired from Author's Solution
    private static ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set, int index){
        System.out.println("(" + set + ", " + index + ")");
        ArrayList<ArrayList<Integer>> powerSet;
        if(set.size() == index){
            powerSet = new ArrayList<>();
            powerSet.add(new ArrayList<>());
            return powerSet;
        }
        powerSet = getPowerSet(set, index+1);
        int item = set.get(index);
        ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
        ArrayList<Integer> newSubset;
        for(ArrayList<Integer> subset : powerSet){
            newSubset = new ArrayList<>(subset);
            newSubset.add(item);
            moreSubsets.add(newSubset);
        }
        powerSet.addAll(moreSubsets);
        return powerSet;
    }

    //My Stupid Previous Solution
    private static Set<Set<Integer>> getPowerSet2(Set<Integer> set){
        Set<Set<Integer>> powerSet = new HashSet<>();
        powerSet.add(new HashSet<>());
        powerSet.add(set);
        for(int x : set){
            powerSet.add(new HashSet<>(Collections.singletonList(x)));
            Set<Integer> newSet = new HashSet<>(set);
            newSet.remove(x);
            powerSet.addAll(getPowerSet2(newSet));
        }
        return powerSet;
    }

    //Another way is to use bit manipulation & getting every possible combination
    private static ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set){
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
        int max = 1 << set.size();
        for(int i=0 ; i<max ; i++)
            powerSet.add(getSubsetForCombination(i, set));
        return powerSet;
    }

    private static ArrayList<Integer> getSubsetForCombination(int x, ArrayList<Integer> set){
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        while (x>0){
            int lastBit = x&1;
            if(lastBit == 1)
                subset.add(set.get(index));
            x >>>= 1;
            index++;
        }
        return subset;
    }

}