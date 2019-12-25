package C5_BitManipulation;

public class P3_FlipToWin {

    public static void main(String args[]){
        System.out.println(getLongestSequenceLength2(Integer.parseInt("101111001110", 2)));
    }

    private static int getLongestSequenceLength2(int n){
        if(~n == 0)
            return Integer.BYTES * 8;
        int currentSequenceLength = 0
                , previousSequenceLength = 0
                , maxTillNow = 0;
        while (n > 0){
            int lastBit = n&1;
            if(lastBit == 1) {
                currentSequenceLength++;
            } else {
                previousSequenceLength = (n&2) == 0 ? 0 : currentSequenceLength;
                currentSequenceLength = 0;
            }
            maxTillNow = Math.max(currentSequenceLength + previousSequenceLength + 1, maxTillNow);
            n >>>= 1;
        }
        return maxTillNow;
    }

    private static int getLongestSequenceLength(int n){
        if(~n == 0)
            return Integer.BYTES * 8;
        int currentSequenceLength = 0
                , previousSequenceLength = 0
                , maxTillNow = 0;
        boolean isOneZeroSeen = false;
        while (n > 0){
            int lastBit = n&1;
            n = n >> 1;
            if(lastBit == 1) {
                currentSequenceLength++;
                isOneZeroSeen = false;
            } else if(isOneZeroSeen) {
                currentSequenceLength = 0;
                previousSequenceLength = 0;
            } else {
                previousSequenceLength = currentSequenceLength;
                currentSequenceLength = 0;
                isOneZeroSeen = true;
            }
            if(currentSequenceLength > 0 && previousSequenceLength > 0)
                maxTillNow = Math.max(currentSequenceLength + previousSequenceLength + 1, maxTillNow);
            else
                maxTillNow = Math.max(maxTillNow, Math.max(currentSequenceLength, previousSequenceLength));
        }
        return maxTillNow;
    }

}
