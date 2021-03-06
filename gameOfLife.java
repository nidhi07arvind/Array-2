// Time Complexity : O(N*M) N - no of rows in board, M - columns in board
// Space Complexity : O(1) - no extra space used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//The next states of each element can be found simultaneously by encoding the change of state: 0 -> 1 as 2 and 1 -> 0 as 4.
//For every element, the no of live neighbours are counted using countLives fucntion. 
//A direction array is created to compare the neighbours in all 8 directions. 
//With boundary conditions, live neighbours are counted and rules are applied on each cell.
//After all elements are processed, 4 and 2 are replaced by 0 and 1 respectively.


public class gameOfLife {

    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int alive  = countLives(board, n , m , i , j);
                if(board[i][j] == 1 && (alive < 2 || alive > 3))
                    board[i][j] = 4;
                else if(board[i][j] == 0 && alive == 3)
                    board[i][j] = 2;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 4) board[i][j] = 0;
                if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
    
    private int countLives(int[][] board, int n, int m, int i, int j){
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        int lives = 0;
        for(int[] dir: dirs){
            int row = dir[0]+i;
            int col = dir[1]+j;
            if(row >= 0 && row < n && col >= 0 && col < m && (board[row][col] == 1 || board[row][col] == 4)){
                lives++;
            }
        }
        return lives;
    }
}
