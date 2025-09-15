class Solution {
    public boolean stringStack(String pat, String tar) {
        // code here
        int i = pat.length() -1;
        int j = tar.length() -1;
        int skip = 0;
        while(i >= 0){
            if(skip > 0){
                skip--;
                i--;
            }else if (j >= 0 && pat.charAt(i) == tar.charAt(j)){
                i--;
                j--;
            }else{
                skip++;
                i--;
            }
        }
        
        return j < 0;
        
    }
}
