package C1_ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class P4_PalindromePermutation {

    public static void main(String args[]){
        check("LAVISH", "Tact Coa");
    }

    private static boolean isPalindromePermutation(String s){
        s = s.toLowerCase();

        Map<Character, Integer> characterOccMap = new HashMap<>();
        for(Character c : s.toCharArray()){
            if(c == ' ')
                continue;
            if(characterOccMap.containsKey(c))
                characterOccMap.put(c, characterOccMap.get(c) + 1);
            else
                characterOccMap.put(c, 1);
        }

        boolean isMidFound = false;
        for(Map.Entry<Character, Integer> entry : characterOccMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (isMidFound)
                    return false;
                else
                    isMidFound = true;
            }
        }
        return true;
    }

    private static void check(String... in){
        for(String s: in){
            System.out.println(String.format("IN : \"%s\"", s));
            System.out.println(String.format("OUT : %b", isPalindromePermutation(s)));
            System.out.println();
        }
    }

}
