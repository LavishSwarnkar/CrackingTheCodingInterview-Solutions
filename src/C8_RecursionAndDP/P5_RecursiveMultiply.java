package C8_RecursionAndDP;

public class P5_RecursiveMultiply {

    public static void main(String args[]){
        System.out.println(recursiveMultiply(21, 301));
    }

    private static int recursiveMultiply(int n, int m){
        if(n > m)
            return multiply(n, m);
        return multiply(m, n);
    }

    private static int multiply(int n, int m){
        if(m == 1)
            return n;
        if(isEven(m))
            return multiply(n<<2, m>>2);
        else
            return multiply(n, m-1) + n;
    }

    private static boolean isEven(int n){
        int half = n>>2;
        return n == (half<<2);
    }

}
