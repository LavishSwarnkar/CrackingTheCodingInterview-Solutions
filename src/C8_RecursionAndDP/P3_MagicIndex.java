package C8_RecursionAndDP;

public class P3_MagicIndex {

    public static void main(String args[]){
        System.out.println(getMagicIndex(new int[]{-10, -6, -3, 3, 10}));
        System.out.println(getMagicIndex2(new int[]{-10, -9, -8, 0, 3, 4, 6, 6}));
    }

    private static int getMagicIndex(int[] arr){
        return getMagicIndex(arr, 0, arr.length-1);
    }

    private static int getMagicIndex(int[] arr, int start, int end){
        if(end < start)
            return -1;
        int mid = (start + end) / 2;
        if(arr[mid] == mid)
            return mid;
        else if(arr[mid] > mid)
            return getMagicIndex(arr, start, mid-1);
        else
            return getMagicIndex(arr, mid+1, end);
    }

    private static int getMagicIndex2(int[] arr){
        return getMagicIndex(arr, 0, arr.length-1);
    }

    private static int getMagicIndex2(int[] arr, int start, int end){
        if(end < start)
            return -1;
        int mid = (start + end) / 2;
        if(arr[mid] == mid)
            return mid;

        int leftSearchResult = getMagicIndex2(arr, start, Math.min(mid-1, arr[mid]));
        if(leftSearchResult >= 0)
            return leftSearchResult;

        return getMagicIndex2(arr, Math.max(mid+1, arr[mid]), end);
    }

}
