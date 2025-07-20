class Solution {
    public int countValid(int n, int[] arr) {
        // code here
        boolean[] forbidden = new boolean[10];
        for (int digit : arr) {
            forbidden[digit] = true;
        }

        List<Integer> allowed = new ArrayList<>();
        List<Integer> allowedFirst = new ArrayList<>();

        for (int d = 0; d <= 9; d++) {
            if (!forbidden[d]) {
                allowed.add(d);
                if (d != 0) {
                    allowedFirst.add(d);
                }
            }
        }
        
        int total = 9 * (int)Math.pow(10, n - 1);

        if (allowedFirst.size() == 0) return total; 

        int invalid = allowedFirst.size();
        for (int i = 1; i < n; i++) {
            invalid *= allowed.size();
        }


        return total - invalid;
    }
}
