package C1_ArraysAndStrings;

public class P9_StringRotation {

    public static void main(String args[]){
        check("water-bottle", "er-bottlewat");
        check("ACBCDA", "CDAACB");
        check("ACCE", "CDAB");
        check("ABCDA", "CDAAB");
        check("WAAB", "ABWA");
        check("WAAAB", "BWAAA");
        check("AAB", "BAA");
    }

    //Using just one call to isSubstring(
    private static boolean isStringRotated2(String s1, String s2) {
        return s1.length() == s2.length() && isSubstring(s2, s1 + s1);
    }

    //Algorithm for actual rotationCheck
    private static boolean isStringRotated(String s1, String s2){
        if(s1.length() != s2.length())
            return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int i=0, j=0;
        while(c1[i] != c2[j])
            i++;
        for( ; i<c1.length ; i++){
            if(c1[i] != c2[j]){
                if(i == c2.length - 1)
                    return false;
                j=0;
                if(c1[i] == c1[i-1])
                    i--;
            }
            else
                j++;
        }

        return isSubstring(s2.substring(j, c2.length), s1);
    }

    private static void check(String s1, String s2){
        System.out.println(String.format("IN : \"%s\", \"%s\"", s1, s2));
        System.out.println(String.format("OUT : %b", isStringRotated2(s1, s2)));
        System.out.println();
    }

    static boolean isSubstring(String s1, String s2)
    {   int M = s1.length();
        int N = s2.length();

        for (int i = 0; i <= N - M; i++) {
            int j;

            for (j = 0; j < M; j++)
                if (s2.charAt(i + j) != s1.charAt(j))
                    break;

            if (j == M)
                return true;
        }

        return false;
    }

}