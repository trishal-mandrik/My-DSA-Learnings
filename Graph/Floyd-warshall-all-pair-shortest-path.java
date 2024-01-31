package Graph;

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        // If Matrix[i][j]=-1, it means there is no edge from i to j. Put 1e9 there
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int)(1e9);
                }
                if(i == j) matrix[i][j] = 0;
            }
        }
        
        // Taking k as intermediate node
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
        // If no path exist place -1 there
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == (int)(1e9)){
                    matrix[i][j] = -1;
                }
            }
        }
    }
}