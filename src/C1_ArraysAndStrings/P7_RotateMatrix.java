package C1_ArraysAndStrings;

import java.util.Arrays;

public class P7_RotateMatrix {

    public static void main(String args[]){
        int a[][] = {{1, 2, 3}
                    , {4, 5, 6}
                    , {7, 8, 9}};
        check(a, true);
        check(a, false);
    }

    private static int[][] rotateMatrix(int in[][], boolean rotateClockWise){
        int out[][] = new int[in.length][in.length];

        for (int i=0 ; i<in.length ; i++){
            for (int j=0 ; j<in.length ; j++){
                out[i][j] = rotateClockWise ?
                        in[in.length - j - 1][i] :
                        in[j][in.length - i - 1];
            }
        }

        return out;
    }

    private static void check(int in[][], boolean rotateClockWise){
        System.out.println(String.format("IN : %s, %b", getMatrixString(in), rotateClockWise));
        System.out.println(String.format("OUT : %s", getMatrixString(rotateMatrix(in, rotateClockWise))));
        System.out.println();
    }

    private static String getMatrixString(int a[][]){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int[] row : a)
            builder.append(Arrays.toString(row)).append(", ");
        builder.delete(builder.length()-2, builder.length());
        return builder.append("]").toString();
    }
}
