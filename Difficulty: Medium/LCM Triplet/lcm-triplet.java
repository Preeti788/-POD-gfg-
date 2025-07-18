class Solution {
    int lcmTriplets(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 6;

        long maxLcm = 0;
        for (int i = n; i >= n - 4; i--) {
            for (int j = i - 1; j >= n - 4; j--) {
                for (int k = j - 1; k >= n - 4; k--) {
                    if (i > 0 && j > 0 && k > 0) {
                        long lcm = lcm(i, lcm(j, k));
                        maxLcm = Math.max(maxLcm, lcm);
                    }
                }
            }
        }

        return (int) maxLcm;
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    long lcm(long a, long b) {
        return (a / gcd(a, b)) * b; 
    }
}
