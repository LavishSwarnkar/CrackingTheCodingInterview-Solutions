package C1_ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class P1_IsUnique {

    public static void main(String args[]){
        check("LAVISH", "LAVISH SWARNKAR", "ABCD", "AABC");
    }

    //Approach 1 using map
    private static boolean hasAllUniqueCharactersA1(String s){
        Map<Character, Boolean> characterBooleanMap = new HashMap<>();
        for(Character c : s.toCharArray())
            if(characterBooleanMap.containsKey(c))
                return false;
            else
                characterBooleanMap.put(c, true);
        return true;
    }

    //Approach 2 using bitVector
    private static boolean hasAllUniqueCharactersA2(String s){
        s = s.toUpperCase();
        int count = 0;
        for (Character c : s.toCharArray()) {
            int i = c - 'A';
            if((count & 1 << i) > 0)
                return false;
            count |= 1 << i;
        }
        return true;
    }

    private static void check(String... in){
        for(String s: in){
            System.out.print("The string \"" + s);
            if(hasAllUniqueCharactersA2(s))
                System.out.println("\" has all unique characters.");
            else
                System.out.println("\" has some duplicate character(s).");
        }
    }

}
