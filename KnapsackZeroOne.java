/**
 * KnapsackZeroOne
 */
public class KnapsackZeroOne {
    public  static int zeroOneKnapsack(int[] weights,int[] values,int capacity){
        int n = weights.length;
        
        // DP table to store maximum value at each capacity
        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) { 
                    // Max of including the item or excluding it
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    // Exclude the item if it can't fit
                    dp[i][w] = dp[i - 1][w];
                }
                for(int[] x:dp){
                    for(int y:x){
                        System.out.print(y+"  ");
                    }
                    System.out.println();
                    
                }
                System.out.println("-------------------");
            }
        }
        
        return  dp[n][capacity];
    }

    public static void main(String[] args) {

        int values[]={60,10,30};
        int weights[]={10,20,30};
        int capacity=40;
        int maxProfit=zeroOneKnapsack(weights,values,capacity);
        System.out.println(maxProfit);

    }
}