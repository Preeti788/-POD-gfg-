class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int target, int k,
                           ArrayList<Integer> path,
                           ArrayList<ArrayList<Integer>> result) {
        if (target == 0 && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || path.size() > k) return;

        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtrack(i + 1, target - i, k, path, result);
            path.remove(path.size() - 1);
        }
    }
}
