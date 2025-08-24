class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;
        if ((long) m * k > n) return -1;
        
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val < low) low = val;
            if (val > high) high = val;
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canMake(arr, k, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private boolean canMake(int[] arr, int k, int m, int day) {
        int bouquets = 0, count = 0;
        for (int val : arr) {
            if (val <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                    if (bouquets >= m) return true;
                }
            } else {
                count = 0;
            }
        }
        return bouquets >= m;
    }
}
