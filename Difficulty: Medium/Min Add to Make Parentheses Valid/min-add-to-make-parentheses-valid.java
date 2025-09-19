class Solution {
    public int minParentheses(String s) {
        // code here
        int open = 0, insert = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                open++;
            }else{
                if(open > 0){
                    open--;
                }else{
                    insert++;
                }
            }
        }
        
        return insert + open;
    }
}
