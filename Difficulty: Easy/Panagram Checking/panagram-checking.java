class Solution {
    public static boolean checkPangram(String s) {
        // code here
        boolean[] seen = new boolean[26];
        int count = 0;
        
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                char ch = Character.toLowerCase(c);
                int idx = ch - 'a';
                if(!seen [idx]){
                    seen[idx] = true;
                    count++;
                    if(count == 26) return true;
                }
            }
        }
        
        return count == 26;
    }
}