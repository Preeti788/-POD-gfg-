class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        // code here
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        backtrack(arr, new ArrayList<>(), used, result);
        return result;
    }

    private static void backtrack(int[] arr, ArrayList<Integer> current, boolean[] used, ArrayList<ArrayList<Integer>> result) {
        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;
            current.add(arr[i]);
            used[i] = true;
            backtrack(arr, current, used, result);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
