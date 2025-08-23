class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(k>n) return -1;
        
        int low = 0, high = 0;
        for(int pages : arr){
            low = Math.max(low, pages);
            high += pages;
        }
        
        while (low < high){
            int mid = low + (high-low)/2;
            if(isPossible(arr, k, mid)){
                high = mid;
            }else {
                low = mid +1;
         
                
            }
                
        } 
        
        return low;
    }
    
    private boolean isPossible(int[] arr, int k, int limit){
        int students = 1, current = 0;
        for(int pages : arr){
            if(current + pages > limit){
                students++;
                current = pages;
                if(students > k) return false;
            }else{
                current += pages;
            }
        }
        
        return true;
    }
}