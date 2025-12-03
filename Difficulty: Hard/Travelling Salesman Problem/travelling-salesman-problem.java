class Solution {
    public int tsp(int[][] cost) {
        int n = cost.length;
        int FULL = (1 << n);
        int[][] dp = new int[FULL][n];

        for (int i = 0; i < FULL; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }

        dp[1][0] = 0;

        for (int mask = 0; mask < FULL; mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) != 0) {
                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) == 0) {
                            int nextMask = mask | (1 << v);
                            dp[nextMask][v] = Math.min(dp[nextMask][v],
                                    dp[mask][u] + cost[u][v]);
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        int finalMask = FULL - 1;

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[finalMask][i] + cost[i][0]);
        }

        return ans;
    }
}
