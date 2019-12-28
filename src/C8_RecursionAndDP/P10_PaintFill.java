package C8_RecursionAndDP;

import java.util.Arrays;

public class P10_PaintFill {

    public static void main(String args[]){
        int[][] points = new int[][]{
                {1, 1, 1, 1, 2},
                {1, 1, 1, 2, 1},
                {1, 1, 2, 1, 1},
                {1, 2, 1, 1, 1},
                {2, 1, 1, 1, 1}
        };
        Screen screen = new Screen(points);
        screen.paintFill(4, 4, 5);
        for(int i=0 ; i<screen.rows ; i++) {
            for (int j = 0; j < screen.cols; j++)
                System.out.print(screen.points[i][j] + "\t");
            System.out.println();
        }
    }

    private static class Screen{
        int[][] points;
        int rows, cols;

        Screen(int [][] points){
            this.points = points;
            rows = points.length;
            cols = points[0].length;
        }

        void paintFill(int r, int c, int fillColor){
            if(!isValidPoint(r, c) || points[r][c] == fillColor)
                return;

            int originalColor = points[r][c];
            points[r][c] = fillColor;
            fillNeighbours(r, c, fillColor, originalColor);
        }

        private void fillNeighbours(int r, int c, int fillColor, int originalColor){
            if(isValidPoint(r, c-1) && points[r][c-1] == originalColor)
                paintFill(r, c-1, fillColor);
            if(isValidPoint(r, c+1) && points[r][c+1] == originalColor)
                paintFill(r, c+1, fillColor);
            if(isValidPoint(r-1, c) && points[r-1][c] == originalColor)
                paintFill(r-1, c, fillColor);
            if(isValidPoint(r+1, c) && points[r+1][c] == originalColor)
                paintFill(r+1, c, fillColor);
        }

        boolean isValidPoint(int r, int c){
            return r>=0 && r<rows && c>=0 && c<cols;
        }
    }
}