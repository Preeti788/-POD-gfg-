class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here
        HashMap<Character, Integer> first = new HashMap<>();
        HashMap<Character, Integer> last = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!first.containsKey(ch)){
                first.put(ch, i);
            }
            last.put(ch,i);
        }
        
        for(char ch : first.keySet()){
            int start = first.get(ch);
            int end = last.get(ch);
            
            if(start < end){
                int sum = 0;
                for(int i = start +1; i<end; i++){
                    sum += (int) s.charAt(i);
                }
                
                if(sum > 0){
                    result.add(sum);
                }
            }
        }
        
        return result;
        
        
    }
}