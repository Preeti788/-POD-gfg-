class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        Arrays.sort(prices);
        int n = prices.length;

        int minCost = 0;
        int start = 0, end = n - 1;
        while (start <= end) {
            minCost += prices[start++];
            end -= k; 
        }

       
        int maxCost = 0;
        start = 0;
        end = n - 1;
        while (start <= end) {
            maxCost += prices[end--];
            start += k;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(minCost);
        result.add(maxCost);
        return result;
    }
}
