package C5_BitManipulation;

public class P5_CheckPowerOf2 {

    public static void main(String args[]){
        System.out.println(isPowerOfTwo(32));
        System.out.println(isPowerOfTwo(35));
    }

    private static boolean isPowerOfTwo(int x){
        return (x & (x-1)) == 0;
    }

}
