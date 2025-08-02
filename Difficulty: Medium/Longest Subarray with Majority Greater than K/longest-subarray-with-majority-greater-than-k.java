class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        int[] mapped = new int[n];
        
        for (int i = 0; i < n; i++) {
            mapped[i] = arr[i] > k ? 1 : -1;
        }

        Map<Integer, Integer> firstIndex = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += mapped[i];

            if (sum > 0) {
                maxLen = i + 1;
            }


            if (!firstIndex.containsKey(sum)) {
                firstIndex.put(sum, i);
            }

    
            if (firstIndex.containsKey(sum - 1)) {
                maxLen = Math.max(maxLen, i - firstIndex.get(sum - 1));
            }
        }

        return maxLen;
    }
}
