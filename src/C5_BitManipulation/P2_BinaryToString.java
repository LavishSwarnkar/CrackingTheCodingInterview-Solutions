package C5_BitManipulation;

public class P2_BinaryToString {

    public static void main(String args[]){
        System.out.println(getBinaryString2(0.125));
    }

    //My Solution
    private static String getBinaryString(double x){
        StringBuilder builder = new StringBuilder();
        double copy = x;
        builder.append(".");
        while (x!=0){
            x *= 2;
            if(x == copy || (builder.length() >= 32 && x>0))
                return "ERROR";
            if(x >= 1){
                x -= 1;
                builder.append(1);
            } else {
                builder.append(0);
            }
        }
        return builder.toString();
    }

    //Alternative approach : Inspired from Author's Solution
    private static String getBinaryString2(double x){
        StringBuilder builder = new StringBuilder();
        builder.append(".");
        double fraction = 0.5;
        while (x!=0){
            if(builder.length() >= 32 && x>0)
                return "ERROR";
            if(x >= fraction){
                x -= fraction;
                builder.append(1);
            } else {
                builder.append(0);
            }
            fraction /= 2;
        }
        return builder.toString();
    }

}
