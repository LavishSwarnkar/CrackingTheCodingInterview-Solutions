package C1_ArraysAndStrings;

public class P3_URLify {

    public static void main(String args[]){
        check("Hey! It's Lavish Swarnkar here.        ", 31);
        check("A B C D      E                  ", 14);
        check("A B C    ", 5);
        check("      ", 2);
    }

    private static String urlify(String s, int length){
        char c[] = s.toCharArray();
        int i = length-1, j = c.length-1;

        while (i>=0){
            if(c[i] != ' ')
                c[j--] = c[i--];

            if(i < 0) break;

            while(c[i] == ' '){
                i--;
                c[j--] = '0';
                c[j--] = '2';
                c[j--] = '%';

                if(i < 0) break;
            }
        }

        return new String(c);
    }

    private static void check(String s, int length){
        System.out.println(String.format("IN : \"%s\", %d", s, length));
        System.out.println(String.format("OUT : \"%s\"", urlify(s, length)));
        System.out.println();
    }

}
