package C8_RecursionAndDP;

import java.util.ArrayList;
import java.util.Collections;

public class P8_PermutationsWithoutDups {

    public static void main(String args[]){
        printPermutations("LAVISH", "");

        //System.out.println(getPermutations("LAVISH", ""));
    }

    private static void printPermutations(String s, String prefix){
        if(s.length() == 1){
            System.out.println(prefix + s);
            return;
        }
        for (int i=0 ; i<s.length() ; i++) {
            printPermutations(s.substring(0, i) + s.substring(i+1, s.length())
                    , prefix + s.charAt(i));
        }
    }

    private static ArrayList<String> getPermutations(String s, String prefix){
        if(s.length() == 1)
            return new ArrayList<>(Collections.singletonList(prefix + s));
        ArrayList<String> permutations = new ArrayList<>();
        for (int i=0 ; i<s.length() ; i++) {
            permutations.addAll(
                    getPermutations(s.substring(0, i) + s.substring(i+1, s.length())
                            , prefix + s.charAt(i))
            );
        }
        return permutations;
    }

}
