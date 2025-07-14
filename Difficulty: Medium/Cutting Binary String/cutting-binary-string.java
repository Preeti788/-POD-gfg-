class Solution {
    public int cuts(String s) {
        // code here
        int n = s.length();
        Set<String> powersOfFive = generatePowerOfFiveBinaryStrings();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if (isValid(sub, powersOfFive)) {
                    if (j == 0) dp[i] = 1;
                    else if (dp[j - 1] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }

    private Set<String> generatePowerOfFiveBinaryStrings() {
        Set<String> set = new HashSet<>();
        long power = 1;
        while (power <= (1L << 30)){
            set.add(Long.toBinaryString(power));
            power *= 5;
        }
        return set;
    }

    private boolean isValid(String sub, Set<String> powers) {
        return !sub.startsWith("0") && powers.contains(sub);
    }
}