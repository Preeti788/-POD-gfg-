class Solution {
    public void setMatrixZeroes(int[][] mat) {
        // code here
        
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[] rowZero = new boolean[n];
        boolean[] colZero = new boolean[m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(rowZero[i] || colZero[j]){
                    mat[i][j] = 0;
                }
            }
        }
        
    }
}