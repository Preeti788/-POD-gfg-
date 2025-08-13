class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
       
        int n = arr.length;
        int luckyCount = 0;
        List<Integer> additions = new ArrayList<>();

        // Step 1: Count already lucky troops and store needed additions for others
        for (int soldiers : arr) {
            if (soldiers % k == 0) {
                luckyCount++;
            } else {
                additions.add(k - (soldiers % k));
            }
        }

        int required = (n + 1) / 2; // ceil(n/2)

        // Step 2: If already enough lucky troops
        if (luckyCount >= required) return 0;

        // Step 3: Sort and pick smallest additions
        Collections.sort(additions);

        int needMore = required - luckyCount;
        int totalAdd = 0;
        for (int i = 0; i < needMore; i++) {
            totalAdd += additions.get(i);
        }

        return totalAdd;
    }
}
