class Solution {
    public int sumOfModes(int[] arr, int k) {
        // code here
        int n = arr.length;
        if (k > n) return 0;

        java.util.HashMap<Integer, Integer> freq = new java.util.HashMap<>();
        java.util.TreeMap<Integer, java.util.TreeSet<Integer>> freqMap = new java.util.TreeMap<>();

        java.util.function.Consumer<Integer> insert = (num) -> {
            int oldFreq = freq.getOrDefault(num, 0);
            if (oldFreq > 0) {
                java.util.TreeSet<Integer> set = freqMap.get(oldFreq);
                set.remove(num);
                if (set.isEmpty()) freqMap.remove(oldFreq);
            }
            int newFreq = oldFreq + 1;
            freq.put(num, newFreq);
            freqMap.putIfAbsent(newFreq, new java.util.TreeSet<>());
            freqMap.get(newFreq).add(num);
        };

        java.util.function.Consumer<Integer> remove = (num) -> {
            int oldFreq = freq.get(num);
            java.util.TreeSet<Integer> set = freqMap.get(oldFreq);
            set.remove(num);
            if (set.isEmpty()) freqMap.remove(oldFreq);
            if (oldFreq == 1) {
                freq.remove(num);
            } else {
                int newFreq = oldFreq - 1;
                freq.put(num, newFreq);
                freqMap.putIfAbsent(newFreq, new java.util.TreeSet<>());
                freqMap.get(newFreq).add(num);
            }
        };

        for (int i = 0; i < k; i++) insert.accept(arr[i]);

        int sum = freqMap.lastEntry().getValue().first();

        for (int i = k; i < n; i++) {
            remove.accept(arr[i - k]);
            insert.accept(arr[i]);
            sum += freqMap.lastEntry().getValue().first();
        }

        return sum;
           
        
        
    }
}