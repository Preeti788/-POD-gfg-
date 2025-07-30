class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;
        
        for(int num : arr){
            prefixSum += num;
            
            if(prefixSum == k){
                count++;
            }
            
            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }
            
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+ 1);
        }
        
        return count;
    }
}