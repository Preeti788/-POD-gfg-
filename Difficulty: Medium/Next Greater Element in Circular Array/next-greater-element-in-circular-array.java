class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> st = new Stack<>();
        for(int i=2*n-1; i>=0; i--){
            int idx = i%n;
            while(!st.isEmpty() && arr[st.peek()] <= arr[idx]){
                st.pop();
                
            }if(!st.isEmpty()){
                res.set(idx,arr[st.peek()]);
            }
            
            st.push(idx);
        }
        
        return res;
        
    }
}