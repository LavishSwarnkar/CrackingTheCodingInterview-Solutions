package C1_ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class P5_OneAway {

    public static void main(String args[]){
        check("PALE", "PLE");
        check("PALES", "PALE");
        check("PALE", "BALE");
        check("PALE", "BAKE");
    }

    private static boolean isOneAway(String s1, String s2){
        if(Math.abs(s1.length() - s2.length()) > 1)
            return false;

        char c1[] = s1.toCharArray()
                , c2[] = s2.toCharArray();

        boolean isOneMismatchFound = false;
        int i=0, j=0;
        while(i<c1.length && j<c2.length){
            if(c1[i] == c2[j]){
                i++; j++;
            } else if(i+1 < c1.length && c1[i+1] == c2[j]) {
                i++;
            } else if(j+1 < c2.length && c1[i] == c2[j+1]) {
                j++;
            } else if(!isOneMismatchFound){
                isOneMismatchFound = true;
                i++; j++;
            } else {
                return false;
            }
        }

        return true;
    }

    private static void check(String s1, String s2){
        System.out.println(String.format("IN : \"%s\", \"%s\"", s1, s2));
        System.out.println(String.format("OUT : %b", isOneAway(s1, s2)));
        System.out.println();
    }

}
