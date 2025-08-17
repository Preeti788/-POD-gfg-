class Solution {
    public int hIndex(int[] citations) {
        // code here
        int n = citations.length;
        int[] bucket = new int[n+1];
        
        for(int c : citations){
            if(c>=n){
                 bucket[n]++;
            } else {
                bucket[c]++;
            }
        }
        
        int papers = 0;
        for (int i = n; i >= 0; i--) {
            papers += bucket[i];
            if (papers >= i) {
                return i;
            }
        }
        return 0;
           
        
    }
}