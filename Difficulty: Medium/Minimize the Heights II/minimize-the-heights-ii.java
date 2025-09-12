class Solution {
    public int getMinDiff(int[] arr, int k) {
        // code here
      
        int n = arr.length;
        sort(arr);
        int ans = arr[n - 1] - arr[0];
        
        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0) continue;
            int minVal = Math.min(arr[0] + k, arr[i] - k);
            int maxVal = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            ans = Math.min(ans, maxVal - minVal);
        }
        return ans;
    }

    private void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    
       
 
    }
}
 