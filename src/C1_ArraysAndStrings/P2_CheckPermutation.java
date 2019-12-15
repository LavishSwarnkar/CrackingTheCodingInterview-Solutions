package C1_ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class P2_CheckPermutation {

    public static void main(String args[]){
        check("LAVISH", "HSLAVI");
        check("ABCD", "ABC");
    }

    private static boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length())
            return false;

        Map<Character, Integer> occMap1 = new HashMap<>()
                , occMap2 = new HashMap<>();
        char c1[] = s1.toCharArray()
                , c2[] = s2.toCharArray();

        for(int i=0 ; i<c1.length ; i++){
            occMap1.put(c1[i], occMap1.containsKey(c1[i]) ? occMap1.get(c1[i]) + 1 : 1);
            occMap2.put(c2[i], occMap2.containsKey(c2[i]) ? occMap2.get(c2[i]) + 1 : 1);
        }

        if(occMap1.size() != occMap2.size())
            return false;

        for(Map.Entry<Character, Integer> entry : occMap1.entrySet())
            if(!(occMap2.containsKey(entry.getKey()) && occMap2.get(entry.getKey()).equals(entry.getValue())))
                return false;

        return true;
    }

    private static void check(String s1, String s2){
        System.out.println(s1 + " is "
                + (isPermutation(s1, s2) ? "" : "NOT ")
                + "a permutation of " + s2);
    }

}
