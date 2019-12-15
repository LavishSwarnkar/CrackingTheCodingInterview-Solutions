package C1_ArraysAndStrings;

public class P6_StringCompression {

    public static void main(String args[]){
        check("LLAAAVVVVIIISSH", "ABCD");
    }

    private static String getCompressedString(String s){
        char c[] = s.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0 ; i<c.length ; i++){
            int count = 1;
            stringBuilder.append(c[i]);
            while(i+1<c.length && c[i] == c[i+1]){
                count++;    i++;
            }
            stringBuilder.append(count);
        }

        String result = stringBuilder.toString();

        return result.length() < s.length() ? result : s;
    }

    private static void check(String... in){
        for(String s: in){
            System.out.println(String.format("IN : \"%s\"", s));
            System.out.println(String.format("OUT : \"%s\"", getCompressedString(s)));
            System.out.println();
        }
    }

}
