class Solution {

    public int maxScore(String s, char[][] jumps) {

        int n = s.length();
        char[] arr = s.toCharArray();

        boolean[][] canJump = new boolean[26][26];
        for (char[] j : jumps) {
            canJump[j[0] - 'a'][j[1] - 'a'] = true;
        }

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + arr[i];
        }

        int[][] count = new int[26][n + 1];
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < 26; c++)
                count[c][i + 1] = count[c][i];
            count[arr[i] - 'a'][i + 1]++;
        }

        int[][] nextOcc = new int[n + 1][26];
        for (int c = 0; c < 26; c++) nextOcc[n][c] = -1;

        for (int i = n - 1; i >= 0; i--) {
            for (int c = 0; c < 26; c++)
                nextOcc[i][c] = nextOcc[i + 1][c];
            nextOcc[i][arr[i] - 'a'] = i;
        }

        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            long best = 0;
            int cFrom = arr[i] - 'a';

            int nextSame = nextOcc[i + 1][cFrom];
            if (nextSame != -1) {
                best = Math.max(best, score(i, nextSame, pref, count, arr) + dp[nextSame]);
            }

            for (int c2 = 0; c2 < 26; c2++) {
                if (!canJump[cFrom][c2]) continue;
                int nxt = nextOcc[i + 1][c2];
                if (nxt != -1) {
                    best = Math.max(best, score(i, nxt, pref, count, arr) + dp[nxt]);
                }
            }

            dp[i] = best;
        }

        return (int) dp[0];
    }

    long score(int i, int j, long[] pref, int[][] count, char[] arr) {
        long total = pref[j] - pref[i];
        int c = arr[j] - 'a';
        int occ = count[c][j] - count[c][i];
        return total - (long) occ * arr[j];
    }
}
