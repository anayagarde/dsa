package com.algo.dsa;

public class HW3Q10 {


        public int maxCoins(int[] nums) {
            int n = nums.length;

            // Extend the nums array by adding 1 at both ends
            int[] extendedNums = new int[n + 2];
            extendedNums[0] = 1;
            extendedNums[n + 1] = 1;
            for (int i = 0; i < n; i++) {
                extendedNums[i + 1] = nums[i];
            }

            // Create a DP table
            int[][] dp = new int[n + 2][n + 2];

            // Fill the DP table
            for (int length = 2; length <= n + 1; length++) { // length of the range (i, j)
                for (int i = 0; i <= n + 1 - length; i++) {    // start of the range
                    int j = i + length;                        // end of the range
                    for (int k = i + 1; k < j; k++) {          // k is the last balloon to burst
                        dp[i][j] = Math.max(dp[i][j],
                                dp[i][k] + dp[k][j] + extendedNums[i] * extendedNums[k] * extendedNums[j]);
                    }
                }
            }

            // The answer is dp[0][n+1]
            return dp[0][n + 1];
        }

        public static void main(String[] args) {
            HW3Q10 bb = new HW3Q10();
            int[] nums = {3, 1, 5, 8};
            System.out.println(bb.maxCoins(nums));  // Output should be 167
        }

}
