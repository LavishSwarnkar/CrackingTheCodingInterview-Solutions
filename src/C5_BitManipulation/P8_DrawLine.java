package C5_BitManipulation;

import java.util.Arrays;

public class P8_DrawLine {

    public static void main(String args[]){
        byte[] screen = new byte[]{0, 0, 0, 0, 0, 0};
        screen = drawLine(screen, 16, 2, 19, 1);
        System.out.println(Arrays.toString(screen));
    }

    private static byte[] drawLine(byte[] screen, int width, int x1 , int x2 , int y){
        int widthInBytes = width/8, firstByteOfRowToModify = widthInBytes * y;
        int indexOfFirstByteToModify = (x1/8) + firstByteOfRowToModify
                , indexOfLastByteToModify = (x2/8) + firstByteOfRowToModify;
        for(int i=indexOfFirstByteToModify+1 ; i<indexOfLastByteToModify ; i++)
            screen[i] = 1;
        if (indexOfFirstByteToModify == indexOfLastByteToModify){
            screen[indexOfFirstByteToModify] = setOnesInRange(screen[indexOfFirstByteToModify], x1%8, x2%8);
        } else {
            screen[indexOfFirstByteToModify] = setOnesInRange(screen[indexOfFirstByteToModify], x1%8, 7);
            screen[indexOfLastByteToModify] = setOnesInRange(screen[indexOfLastByteToModify], 0, x2%8);
        }
        return screen;
    }

    private static byte setOnesInRange(byte x, int i, int j){
        return (byte) ((x & ~(((1<<(j-i+1))-1)<<(7-j))) | ((1<<(j-i+1))-1)<<(7-j));
    }

}
