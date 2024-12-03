
import java.util.*;

class Subsetsum {


       static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;

        // Create a 2D array for storing results of
        // subproblems
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // If sum is 0, then answer is true
          // (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1]) {
                  
                    // Exclude the current element
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                  
                    // Include or exclude
                    dp[i][j] = dp[i - 1][j]
                               || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
      
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;

        if (isSubsetSum(arr, sum)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}