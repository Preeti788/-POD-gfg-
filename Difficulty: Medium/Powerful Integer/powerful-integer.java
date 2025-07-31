class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        // code here

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1] + 1, map.getOrDefault(interval[1] + 1, 0) - 1);
        }

        int curr = 0;
        int last = -1;
        int maxPowerful = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int point = entry.getKey();
            curr += entry.getValue();

            if (curr >= k) {
                last = point;
            } else {
                if (last != -1) {
                    maxPowerful = Math.max(maxPowerful, point - 1); 
                    last = -1;
                }
            }
        }

        return maxPowerful;
    }
}


