package C8_RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

public class P2_RobotInGrid {

    public static void main(String args[]){
        boolean[][] grid = new boolean[][]{
                {true, false, true, true, true}
                , {true, true, false, true, true}
                , {false, true, true, false, true}
                , {true, false, true, true, false}
                , {true, true, false, true, true}
        };
        System.out.println(getPath(grid, 4, 4));
    }

    private static List<Point> getPath(boolean[][] grid, int r, int c){
        ArrayList<Point> path = new ArrayList<>();
        if(doesPathExists(grid, r-1, c, path) || doesPathExists(grid, r, c-1, path, new ArrayList<>()))
            return path;
        return null;
    }

    private static boolean doesPathExists(boolean[][] grid, int r, int c, List<Point> path){
        if(r<0 || c<0 || !grid[r][c])
            return false;

        boolean isAtOrigin = r+c==0;

        if(isAtOrigin || doesPathExists(grid, r-1, c, path) || doesPathExists(grid, r, c-1, path)){
            path.add(new Point(r, c));
            return true;
        }

        return false;
    }

    private static boolean doesPathExists(boolean[][] grid, int r, int c, List<Point> path, List<Point> blockages){
        if(r<0 || c<0 || !grid[r][c] || blockages.contains(new Point(r, c)))
            return false;

        boolean isAtOrigin = r+c==0;

        if(isAtOrigin || doesPathExists(grid, r-1, c, path) || doesPathExists(grid, r, c-1, path)){
            path.add(new Point(r, c));
            return true;
        }

        blockages.add(new Point(r, c));
        return false;
    }

    private static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", r, c);
        }
    }

}
