package C5_BitManipulation;

public class P7_PairwiseSwap {

    private static final int MAGIC_NO = 715827882;

    public static void main(String args[]){
        System.out.println(Integer.toBinaryString(swapPairwise2(Integer.parseInt("1011101", 2))));
        System.out.println(Integer.toBinaryString(swapPairwise2(Integer.parseInt("1001111", 2))));
        System.out.println(Integer.toBinaryString(swapPairwise2(Integer.parseInt("1111101", 2))));
        System.out.println(Integer.toBinaryString(swapPairwise2(Integer.parseInt("1011011", 2))));
        System.out.println(Integer.toBinaryString(swapPairwise2(Integer.parseInt("1101101", 2))));
    }

    //Author's Solution
    private static int swapPairwise2(int x){
        return ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1);
    }

    //My Solution
    private static int swapPairwise(int x){
        return ((x & (MAGIC_NO >>> 1)) << 1) | ((x & MAGIC_NO) >>> 1);
    }

}
