package C8_RecursionAndDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P11_Coins {

    public static void main(String args[]){
        System.out.println(getNoOfWays(new int[]{1, 5, 10, 15}, 10));
    }



    private static int getNoOfWays(int[] coins, int n){
        List<Integer> avoidCalls = new ArrayList<>();
        int ways = 0;
        for(int coin : coins){
            if(avoidCalls.contains(coin))
                continue;
            if(n - coin == 0) {
                ways++;
            } else if(n - coin > 0) {
                ways += getNoOfWays(coins, n - coin);
                avoidCalls.add(n - coin);
            }
        }
        return ways;
    }

}
