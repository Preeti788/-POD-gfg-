class Solution {
    
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
        int count = 0;
    }
    
    void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 16; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null)
                node.children[bit] = new TrieNode();
            node = node.children[bit];
            node.count++;
        }
    }
    
    int countLess(TrieNode root, int num, int k) {
        TrieNode node = root;
        int cnt = 0;
        for (int i = 16; i >= 0 && node != null; i--) {
            int nBit = (num >> i) & 1;
            int kBit = (k >> i) & 1;
            
            if (kBit == 1) {
                if (node.children[nBit] != null)
                    cnt += node.children[nBit].count;
                node = node.children[1 - nBit];
            } else {
                node = node.children[nBit];
            }
        }
        return cnt;
    }
    
    public int cntPairs(int[] arr, int k) {
        TrieNode root = new TrieNode();
        int res = 0;
        for (int num : arr) {
            res += countLess(root, num, k);
            insert(root, num);
        }
        return res;
    }
}
