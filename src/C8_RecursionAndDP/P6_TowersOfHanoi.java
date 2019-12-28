package C8_RecursionAndDP;

import java.util.Stack;

public class P6_TowersOfHanoi {

    public static void main(String args[]){
        int N = 5;

        Stack<Disk> src = new Stack<>(), dest = new Stack<>(), aux = new Stack<>();
        for (int i=N ; i>=1 ; i--)
            src.push(new Disk(i));

        System.out.println(String.format("Before:\nSrc:%s\nDest:%s\nAux:%s", src, dest, aux));
        move(N, src, dest, aux);
        System.out.println(String.format("\nAfter:\nSrc:%s\nDest:%s\nAux:%s", src, dest, aux));
    }

    private static class Disk{
        int size;
        Disk(int size){
            this.size = size;
        }

        @Override
        public String toString() {
            return "" + size;
        }
    }

    private static void move(int N, Stack<Disk> src, Stack<Disk> dest, Stack<Disk> aux){
        if(N == 1){
            dest.push(src.pop());
        } else {
            move(N-1, src, aux, dest);
            move(1, src, dest, aux);
            move(N-1, aux, dest, src);
        }
    }

}
