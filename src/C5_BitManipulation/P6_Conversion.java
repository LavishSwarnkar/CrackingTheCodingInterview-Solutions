package C5_BitManipulation;

public class P6_Conversion {

    public static void main(String args[]){
        System.out.println(getNoOfFlipsForConversion(29, 3));
    }

    private static int getNoOfFlipsForConversion(int x, int y){
        int noOfFlips = 0;
        while (x > 0 || y > 0){
            if(x == 0 || y == 0 || ((x&1)!=(y&1)))
                noOfFlips++;
            x >>>= 1;
            y >>>= 1;
        }
        return noOfFlips;
    }

}
