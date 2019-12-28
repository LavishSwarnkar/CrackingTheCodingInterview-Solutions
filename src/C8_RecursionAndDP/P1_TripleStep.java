package C8_RecursionAndDP;

import java.util.*;

public class P1_TripleStep {

    public static void main(String args[]){
        //System.out.println(getNoOfWays(7));
        //System.out.println(getWays(7).toString().replace("], [", "]\n["));

        //System.out.println(getNoOfWaysWithVariableHops(new int[]{1, 2, 3}, 7));
        //System.out.println(getWaysWithVariableHops(new int[]{1, 2, 3}, 7).toString().replace("], [", "]\n["));

        //System.out.println(getNoOfWays(7, new int[8]));
        //System.out.println(getNoOfWaysWithVariableHops(new int[]{1, 2, 3}, 7, new int[8]));
        //System.out.println(getWaysWithVariableHops(new int[]{1, 2, 3}, 7, new HashMap<>()).toString().replace("], [", "]\n["));

        System.out.println(getWaysWithVariableHops(new int[]{1, 2, 3}, 4, new HashMap<>()).toString().replace("], [", "]\n["));

        //System.out.println(getNoOfWays2(7));
    }

    //Simplest recursive solution to get noOfWays
    private static int getNoOfWays(int n){
        if(n <= 2)
            return n;
        else if(n == 3)
            return 4;
        return getNoOfWays(n-1) + getNoOfWays(n-2) + getNoOfWays(n-3);
    }

    //Memoization solution
    private static int getNoOfWays(int n, int[] mem){
        if(n <= 2)
            return n;
        else if(n == 3)
            return 4;
        if(mem[n] == 0)
            mem[n] = getNoOfWays(n-1, mem) + getNoOfWays(n-2, mem) + getNoOfWays(n-3, mem);
        return mem[n];
    }

    //Iterative Solution
    private static int getNoOfWays2(int n){
        if(n==1)
            return 1;
        else if(n==2)
            return 2;
        else if(n==3)
            return 4;

        int a=1, b=2, c=4, ways=a+b+c;
        for (int i = 4; i <= n; i++) {
            ways = a+b+c;
            a = b;
            b = c;
            c = ways;
        }
        return ways;
    }

    //Further generalization to support other than just 1, 2 or 3 hops
    private static int getNoOfWaysWithVariableHops(int[] hops, int n){
        if(n == 1)
            return 1;

        int ways = 0;
        for(int hop : hops){
            if(n == hop)
                ways++;
            else if(n > hop)
                ways += getNoOfWaysWithVariableHops(hops, n-hop);
            else break;
        }
        return ways;
    }

    //Memoization solution for generalized solution
    private static int getNoOfWaysWithVariableHops(int[] hops, int n, int[] mem){
        if(n == 1)
            return 1;

        if(mem[n] == 0){
            for(int hop : hops){
                if(n == hop)
                    mem[n]++;
                else if(n > hop)
                    mem[n] += getNoOfWaysWithVariableHops(hops, n-hop, mem);
                else break;
            }
        }

        return mem[n];
    }

    //Taking this problem even further, printing all possible ways
    private static ArrayList<ArrayList<Integer>> getWays(int n){
        ArrayList<ArrayList<Integer>> ways = new ArrayList<>();
        switch (n){
            case 1 : {
                ways.add(new ArrayList<>(Collections.singletonList(1)));
                break;
            } case 2 : {
                ways.add(new ArrayList<>(Collections.singletonList(2)));
                ways.add(new ArrayList<>(Arrays.asList(1, 1)));
                break;
            } case 3 : {
                ways.add(new ArrayList<>(Collections.singletonList(3)));
                ways.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
                ways.add(new ArrayList<>(Arrays.asList(2, 1)));
                ways.add(new ArrayList<>(Arrays.asList(1, 2)));
                break;
            } default : {
                for (int i = 1; i <= 3 ; i++) {
                    ArrayList<ArrayList<Integer>> ways1 = getWays(n-i);
                    for (ArrayList<Integer> way : ways1)
                        way.add(0, i);
                    ways.addAll(ways1);
                }
            }
        }
        return ways;
    }

    //Doing the same with variable hops
    private static ArrayList<ArrayList<Integer>> getWaysWithVariableHops(int[] hops, int n){
        ArrayList<ArrayList<Integer>> ways = new ArrayList<>();

        if(n == 1){
            ways.add(new ArrayList<>(Collections.singletonList(1)));
            return ways;
        }

        for (int hop : hops) {
            if (n == hop) {
                ways.add(new ArrayList<>(Collections.singletonList(hop)));
            } else if(n > hop){
                ArrayList<ArrayList<Integer>> ways1 = getWaysWithVariableHops(hops, n-hop);
                for (ArrayList<Integer> way : ways1)
                    way.add(0, hop);
                ways.addAll(ways1);
            } else break;
        }
        return ways;
    }

    //Memoization solution for the same
    private static ArrayList<ArrayList<Integer>> getWaysWithVariableHops(int[] hops, int n, Map<Integer, ArrayList<ArrayList<Integer>>> mem){
        ArrayList<ArrayList<Integer>> ways = new ArrayList<>();

        if(n == 1){
            ways.add(new ArrayList<>(Collections.singletonList(1)));
            return ways;
        }

        if(!mem.containsKey(n)){
            for (int hop : hops) {
                if (n == hop) {
                    ways.add(new ArrayList<>(Collections.singletonList(hop)));
                } else if(n > hop){
                    ArrayList<ArrayList<Integer>> ways1 = new ArrayList<>();
                    for(ArrayList<Integer> list : getWaysWithVariableHops(hops, n-hop, mem)){
                        ArrayList<Integer> list1 = new ArrayList<>(list);
                        ways1.add(list1);
                    }
                    for (ArrayList<Integer> way : ways1)
                        way.add(0, hop);
                    ways.addAll(ways1);
                } else break;
            }
            mem.put(n, ways);
        }

        return mem.get(n);
    }

}
