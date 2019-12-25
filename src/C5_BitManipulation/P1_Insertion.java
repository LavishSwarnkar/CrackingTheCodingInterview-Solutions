package C5_BitManipulation;

public class P1_Insertion {

    public static void main(String args[]){
        System.out.println(Integer.toBinaryString(insert(Integer.parseInt("10000000000", 2)
                , Integer.parseInt("10011", 2)
                , 2
                , 6)));
    }

    public static int insert(int N, int M, int i, int j){
        return (M<<i) | (N & ~(((1<<(j-i+1))-1)<<i));
    }

}
