class Solution {
    public static int countNumbers(int n) {
        int limit = (int)Math.sqrt(n) + 1;
        boolean[] isPrime = new boolean[limit];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }


        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < limit; i++) {
            if (isPrime[i]) primes.add(i);
        }

        int count = 0;

        for (int p : primes) {
            long power = 1;
            for (int i = 0; i < 8; i++) power *= p;
            if (power <= n) count++;
            else break;
        }

    
        int size = primes.size();
        for (int i = 0; i < size; i++) {
            long p1Sq = (long)primes.get(i) * primes.get(i);
            if (p1Sq > n) break;

            for (int j = i + 1; j < size; j++) {
                long p2Sq = (long)primes.get(j) * primes.get(j);
                if (p1Sq * p2Sq <= n) count++;
                else break;
            }
        }

        return count;
    }
}
