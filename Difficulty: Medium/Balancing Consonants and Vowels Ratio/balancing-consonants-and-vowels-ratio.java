class Solution {
    public int countBalanced(String[] arr) {
        // code here
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u' );
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int balance = 0;
        
        map.put(0, 1);
        
        for(String s : arr){
            for(char ch : s.toCharArray()){
                if(vowels.contains(ch)){
                    balance += 1;
                    
                }else{
                   balance -= 1;
                }
                
            }
            
             count += map.getOrDefault(balance, 0);
             map.put(balance, map.getOrDefault(balance, 0)+1);
        }
        
        return count;
        
    }
}