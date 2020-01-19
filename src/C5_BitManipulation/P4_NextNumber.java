package C5_BitManipulation;

public class P4_NextNumber {

    public static void main(String args[]){
        System.out.println(getNextLargerNumber(90));
        System.out.println(getPreviousSmallerNumber(90));
    }

    private static int getPreviousSmallerNumber(int x){
        int index = 0, noOfOnesSeen = 0, xCopy = x;
        boolean isZeroSeen = false;
        while (x > 0){
            int lastBit = x&1;
            if(lastBit == 1){
                if(isZeroSeen)
                    return shiftLastOneToRightAndOthersToLeft(xCopy, index, noOfOnesSeen);
                noOfOnesSeen++;
            } else {
                isZeroSeen = true;
            }
            index++;
            x >>>= 1;
        }
        return -1;
    }

    private static int shiftLastOneToRightAndOthersToLeft(int x, int index, int noOfOnesSeen) {
        return (x&~((1<<(index+1))-1)) | (((1<<(noOfOnesSeen+1))-1)<<(index-noOfOnesSeen-1));
    }

    private static int getNextLargerNumber(int x){
        int index = 0, noOfOnesSeen = 0, xCopy = x;
        boolean hasLeadingZeroes = false;
        while (x > 0){
            int lastBit = x&1;
            if(lastBit == 1){
                noOfOnesSeen++;
            } else if(noOfOnesSeen == 0){
                hasLeadingZeroes = true;
            } else {
                return shiftOneBitLeft2(xCopy, index-1, noOfOnesSeen);
            }
            index++;
            x >>>= 1;
        }
        x = shiftOneBitLeft(xCopy, index-1);
        if(hasLeadingZeroes)
            return shiftAllOnesRightExceptLast(index, noOfOnesSeen-1);
        return x;
    }

    private static int shiftAllOnesRightExceptLast(int lastOnesIndex, int noOfOtherOnes) {
        return (1 << lastOnesIndex) | ((1 << noOfOtherOnes) - 1);
    }

    private static int shiftOneBitLeft(int x, int index) {
        return (1 << (index + 1)) | (x & ~(1 << index));
    }

    private static int shiftOneBitLeft2(int x, int index, int noOfOnesSeen) {
        int afterShiftedOnePart = shiftAllOnesRightExceptLast(index + 1, noOfOnesSeen-1)
                , remainingPart = shiftOneBitLeft(x, index);
        return (remainingPart & (~((1 << (index + 1))-1))) | afterShiftedOnePart;
    }

}
