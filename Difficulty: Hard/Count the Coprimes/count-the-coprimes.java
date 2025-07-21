class Solution {
    int cntCoprime(int[] arr) {
        // code here
        int n = arr.length;
        int M = 10001;
        int[] freq = new int[M];

        for (int num : arr) {
            freq[num]++;
        }


        int[] divisible = new int[M];
        for (int d = 1; d < M; d++) {
            for (int multiple = d; multiple < M; multiple += d) {
                divisible[d] += freq[multiple];
            }
        }


        int[] mu = new int[M];
        for (int i = 0; i < M; i++) mu[i] = 1;

        boolean[] isPrime = new boolean[M];
        for (int i = 2; i < M; i++) isPrime[i] = true;

        for (int i = 2; i < M; i++) {
            if (!isPrime[i]) continue;
            for (int j = i; j < M; j += i) {
                mu[j] *= -1;
                isPrime[j] = false;
            }
            for (long j = (long) i * i; j < M; j += i * i) {
                mu[(int) j] = 0;
            }
        }

        
        long total = 0;
        for (int d = 1; d < M; d++) {
            int c = divisible[d];
            if (c < 2 || mu[d] == 0) continue;
            long pairs = (long) c * (c - 1) / 2;
            total += mu[d] * pairs;
        }

        return (int) total;
    }
}
