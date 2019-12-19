package C1_ArraysAndStrings;

import java.util.Arrays;

public class P8_ZeroMatrix {

    public static void main(String args[]){
        int a[][] = { {1, 2, 3, 6}
                    , {4, 0, 6, 8}
                    , {7, 8, 9, 0}};
        int b[][] = { {1, 2, 3, 6, 7}
                    , {4, 0, 6, 8, 9}
                    , {7, 8, 9, 7, 0}
                    , {7, 8, 0, 7, 1}};
        int c[][] = { {1, 2, 3, 6, 7}
                    , {4, 3, 6, 8, 9}
                    , {7, 8, 9, 7, 2}
                    , {7, 8, 5, 7, 1}};
        check(a);
        check(b);
        check(c);
    }

    private static int[][] getZeroMatrix(int in[][]){
        int firstColWithZero = -1
                , firstRowWithZero = -1;

        for (int i=0 ; i<in.length ; i++){
            for (int j=0 ; j<in[0].length ; j++){
                if(in[i][j] == 0){
                    if(firstRowWithZero == -1){
                        firstRowWithZero = i;
                        firstColWithZero = j;
                    }else {
                        in[firstRowWithZero][j] = 0;
                        in[i][firstColWithZero] = 0;
                    }
                }
            }
        }

        if(firstRowWithZero > -1){
            for(int i=0 ; i<in[0].length ; i++)
                if(i!=firstColWithZero && in[firstRowWithZero][i] == 0)
                    nullifyCol(in, i);

            for(int i=0 ; i<in.length ; i++)
                if(i!=firstRowWithZero && in[i][firstColWithZero] == 0)
                    nullifyRow(in, i);

            nullifyRow(in, firstRowWithZero);
            nullifyCol(in, firstColWithZero);
        }

        return in;
    }

    private static void nullifyRow(int a[][], int row){
        for(int j=0 ; j<a[0].length ; j++)
            a[row][j] = 0;
    }

    private static void nullifyCol(int a[][], int col){
        for(int j=0 ; j<a.length ; j++)
            a[j][col] = 0;
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
        builder.append("\n[\n ");
        for (int[] row : a)
            builder.append(Arrays.toString(row)).append(",\n ");
        builder.delete(builder.length()-3, builder.length());
        return builder.append("\n]").toString();
    }
}