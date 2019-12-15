package C1_ArraysAndStrings;

public class P9_StringRotation {

    public static void main(String args[]){
        check("water-bottle", "er-bottlewat");
    }

    private static boolean isStringRotated(String s1, String s2){
        if(s1.length() != s2.length())
            return false;

        char c1[] = s1.toCharArray()
                , c2[] = s2.toCharArray();

        int i=0;
        for( ; i<c2.length && c2[i]!=c1[0] ; i++);

        String substr = s2.substring(0, i<=c2.length-1 ? i : c2.length-1);


        return true;
    }

    private static void check(String s1, String s2){
        System.out.println(String.format("IN : \"%s\", \"%s\"", s1, s2));
        System.out.println(String.format("OUT : %b", isStringRotated(s1, s2)));
        System.out.println();
    }

    static boolean isSubstring(String s1, String s2)
    {   int M = s1.length();
        int N = s2.length();

        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) {
            int j;

            /* For current index i, check for
            pattern match */
            for (j = 0; j < M; j++)
                if (s2.charAt(i + j) != s1.charAt(j))
                    break;

            if (j == M)
                return true;
        }

        return false;
    }

}
