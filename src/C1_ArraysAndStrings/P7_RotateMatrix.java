package C1_ArraysAndStrings;

import java.util.Arrays;

public class P7_RotateMatrix {

    public static void main(String args[]){
        int a[][] = {{1, 2, 3, 0}
                , {4, 5, 6, 0}
                , {7, 8, 9, 0}
        }, b[][] = {{1, 2}
                , {4, 5}
                , {7, 8}
        }, c[][] = {{1, 2, 3, 4, 5}
                , {4, 5, 6, 7, 8}
                , {7, 8, 9, 10, 11}
        };
        check(a, true);
        check(a, false);
        check(b, true);
        check(c, true);
    }

    private static int[][] rotateMatrix(int in[][], boolean rotateClockWise){
        int out[][] = new int[in[0].length][in.length];

        for (int i=0 ; i<in[0].length ; i++){
            for (int j=0 ; j<in.length ; j++){
                out[i][j] = rotateClockWise ?
                        in[in.length - j - 1][i] :
                        in[j][in[0].length - i - 1];
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
        builder.append("\n[\n ");
        for (int[] row : a)
            builder.append(Arrays.toString(row)).append(",\n ");
        builder.delete(builder.length()-3, builder.length());
        return builder.append("\n]").toString();
    }
}
