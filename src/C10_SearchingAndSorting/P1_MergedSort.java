package C10_SearchingAndSorting;

import java.util.*;

public class P1_MergedSort {

    public static void main(String args[]) {
        System.out.println(isAnagram("a", "b"));

        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        int[] a = new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0, 0}
            , b = new int[]{2, 4, 6, 8, 10};
        mergedSort(a, b);
        System.out.println(Arrays.toString(a));
    }

    private static void mergedSort(int[] a, int[] b){
        int i = a.length - b.length - 1
                , j = b.length-1
                , k = a.length-1;
        while (i>=0 && j>=0)
            a[k--] = a[i] > b[j] ? a[i--] : b[j--];
        while (j>=0)
            a[k--] = b[j--];
    }

    public static ArrayList<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String sortedString = getSortedString(s);
            if(!map.containsKey(sortedString))
                map.put(sortedString, new ArrayList<>());
            map.get(sortedString).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private static String getSortedString(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }

    private String counts(String word){
        char[] counter = new char[26];
        for(char c:word.toCharArray()){
            counter[c-97]++;
        }
        return new String(counter);
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] x = s.toCharArray();

        char[] c1 = new char[26];
        for (char aX : x) c1[aX - 97]++;

        x = t.toCharArray();
        for (char aX : x) c1[aX - 97]--;

        for(int i=0 ; i<26 ; i++)
            if(c1[i] != 0)
                return false;

        return true;
    }

}
