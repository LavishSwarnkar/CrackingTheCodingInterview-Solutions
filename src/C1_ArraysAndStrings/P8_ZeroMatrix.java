package C1_ArraysAndStrings;

import java.util.Arrays;

public class P8_ZeroMatrix {

    public static void main(String args[]){
        int a[][] = {{1, 2, 3, 6}
                    , {4, 0, 6, 8}
                    , {7, 8, 9, 7}};
        check(a);
    }

    private static int[][] getZeroMatrix(int in[][]){
        for (int i=0 ; i<in.length ; i++){
            for (int j=0 ; j<in[0].length ; j++){
                if(in[i][j] == 0){
                    for(int k=0 ; k<in[0].length ; k++)
                        in[i][k] = 0;
                    break;
                }
            }
        }

        return in;
    }

    private static void check(int[][]... in){
        for(int[][] a: in){
            System.out.println(String.format("IN : %s", getMatrixString(a)));
            System.out.println(String.format("OUT : %s", getMatrixString(getZeroMatrix(a))));
            System.out.println();
        }
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
