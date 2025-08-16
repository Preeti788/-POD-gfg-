class Solution {
    public String findLargest(int[] arr) {
        // code here
        String[] nums = new String[arr.length];
        for(int i=0; i<arr.length; i++) nums[i] = String.valueOf(arr[i]);
        Arrays.sort(nums, (a,b) -> (b+a).compareTo(a+b));
        if(nums[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String num : nums) sb.append(num);
        return sb.toString();
        
    }
}