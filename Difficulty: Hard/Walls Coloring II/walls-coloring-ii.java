class Solution {
    int minCost(int[][] costs) {
        // code here
        int n = costs.length;
        if(n==0) return 0;
        
        int k = costs[0].length;
        
        if(k == 1){
            return (n==1) ? costs[0][0] : -1;
        }
        
        int[] dp = new int[k];
        
        for(int j = 0; j < k; j++){
            dp[j] = costs[0][j];
        }
        
        for(int i = 1; i < n; i++){
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int min1Index = -1;
            
            for(int j = 0; j < k; j++){
                if(dp[j] < min1){
                    min2 = min1;
                    min1 = dp[j];
                    min1Index = j;
                    
                    
                }else if (dp[j] < min2){
                    min2 = dp[j];
                }
            }
            
            int[] newDp = new int[k];
            
                        for (int j = 0; j < k; j++) {
                if (j == min1Index) {
                    newDp[j] = costs[i][j] + min2;
                } else {
                    newDp[j] = costs[i][j] + min1;
                }
            }

            dp = newDp;
        }

        int ans = Integer.MAX_VALUE;
        for (int val : dp) {
            ans = Math.min(ans, val);
        }

        return ans;

        
        
    }
}