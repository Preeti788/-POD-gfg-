class Solution {

    private String[] mapping = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<Integer> digits = new ArrayList<>();
        for(int num : arr) if(num >= 2 && num <= 9) digits.add(num);

        ArrayList<String> result = new ArrayList<>();
        if(digits.isEmpty()) return result;

        result.add(""); 
        for(int num : digits) {
            String letters = mapping[num];
            ArrayList<String> temp = new ArrayList<>();
            for(String s : result) {
                for(char c : letters.toCharArray()) {
                    temp.add(s + c);
                }
            }
            result = temp; 
        }

        return result;
    }
}
