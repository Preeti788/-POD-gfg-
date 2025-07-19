class Solution {
    public int vowelCount(String s) {
        // code here
        int[] freq = new int[5];
        for (char c : s.toCharArray()) {
            if (c == 'a') freq[0]++;
            else if (c == 'e') freq[1]++;
            else if (c == 'i') freq[2]++;
            else if (c == 'o') freq[3]++;
            else if (c == 'u') freq[4]++;
        }
        int uniqueVowels = 0;
        int totalChoices = 1;
        for (int f : freq) {
            if (f > 0) {
                uniqueVowels++;
                totalChoices *= f;
            }
        }
        
        if (uniqueVowels == 0) return 0;
        int permutations = 1;
        for (int i = 2; i <= uniqueVowels; i++) {
            permutations *= i;
        }

        return totalChoices * permutations;
    }
}

    