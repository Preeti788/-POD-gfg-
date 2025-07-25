class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
        int n = arr.length;

        int totalSum = 0;
        int maxKadane = Integer.MIN_VALUE, curMax = 0;
        int minKadane = Integer.MAX_VALUE, curMin = 0;

        for (int i = 0; i < n; i++) {
            int val = arr[i];
            totalSum += val;

    
            curMax = Math.max(val, curMax + val);
            maxKadane = Math.max(maxKadane, curMax);

            curMin = Math.min(val, curMin + val);
            minKadane = Math.min(minKadane, curMin);
        }


        if (maxKadane < 0)
            return maxKadane;
        return Math.max(maxKadane, totalSum - minKadane);
    }
}
