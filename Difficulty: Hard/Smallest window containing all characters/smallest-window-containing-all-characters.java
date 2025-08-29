class Solution {
    public static String smallestWindow(String s, String p) {
        // code here
        if(s.length()<p.length()) return "";
        
        int[] need = new int[26];
        int[] have = new int[26];
        
        for(char c : p.toCharArray()){
            need[c - 'a']++;
        }
        
        int required = p.length();
        int left = 0, minLen = Integer.MAX_VALUE, start = 0;
        
        
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            have[c-'a']++;
            
            if (need[c-'a'] > 0 && have[c - 'a'] <= need[c-'a']){
                required--;
            }
            
            while(required == 0){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }
                
                char lc = s.charAt(left);
                have[lc -'a']--;
                if(need[lc-'a'] > 0 && have[lc-'a'] < need[lc-'a']){
                    required++;
                }
                
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        
    }
}