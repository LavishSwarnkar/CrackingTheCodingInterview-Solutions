package C8_RecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P9_Parens {

    public static void main(String args[]){
        addParen(new ArrayList<>(), 3, 3, new char[6], 0);

        /*System.out.println(getValidCombinations(1));
        System.out.println(getValidCombinations(2));
        System.out.println(getValidCombinations(3));
        System.out.println(getValidCombinations(4));
        System.out.println(getValidCombinations(5));*/
    }

    //My Solution
    private static ArrayList<String> getValidCombinations(int N){
        if(N == 1)
            return new ArrayList<>(Collections.singletonList("()"));
        ArrayList<String> c1 = getValidCombinations(N - 1)
                , c2 = new ArrayList<>();

        for (String c : c1) {
            c2.add(c + "()");

            String s = "(" + c + ")";
            if(!c2.contains(s))
                c2.add(s);

            s = "()" + c;
            if(!c2.contains(s))
                c2.add(s);
        }

        return c2;
    }

    //Author's Solution
    private static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) return; // invalid state

        if (leftRem == 0 && rightRem == 0) { /* all out of left and right parentheses */
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '('; // Add left and recurse
            addParen(list, leftRem - 1, rightRem, str, index + 1);
            System.out.println(String.valueOf(str));
            str[index] = ')'; // Add right and recurse
            addParen(list, leftRem, rightRem - 1, str, index + 1);
            System.out.println(String.valueOf(str));
        }
    }

    private static ArrayList<String> generateParens(int count) {
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }

}