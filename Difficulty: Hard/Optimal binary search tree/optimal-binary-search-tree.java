class Solution {
    public int minCost(int keys[], int freq[]) {
        // code here
        
        int n = keys.length;
        int[][] dp = new int[n][n];
        int[] prefix = new int[n+1];
        
        for(int i=0; i<n; i++){
            prefix[i+1] = prefix[i] + freq[i];
        }
        
        for(int i=0; i<n; i++){
            dp[i][i] = freq[i];
        }
        
        for(int L = 2; L <= n; L++){
            for(int i=0; i+L-1<n; i++){
                int j = i+L-1;
                dp[i][j] = Integer.MAX_VALUE;
                int freqSum = prefix[j+1] - prefix[i];
                
                
                for(int r = i; r <= j; r++){
                    int left = (r > i) ? dp[i][r-1] : 0;
                    int right = (r < j) ? dp[r+1][j] : 0;
                    int cost = left + right + freqSum;
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
                
            }
        }
        
        return dp[0][n-1];
        
    }
}
