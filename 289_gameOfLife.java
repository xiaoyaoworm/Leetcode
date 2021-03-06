public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int num = getLivNum(board,i,j);
                if(board[i][j] == 0 && num == 3) board[i][j]+=10;
                if(board[i][j] == 1 && ((num == 2)||(num == 3))) board[i][j]+=10;
            }
        }
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j < n; j++){
                board[i][j]/=10;
            }
        }
    }
    
    public int getLivNum(int[][] board, int x, int y){
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for(int i = x-1; i<=x+1;i++){
            for(int j = y-1; j<= y+1; j++){
                if(i<0 || i>=m || j<0 || j>=n || (i==x && j== y)) continue;
                if(board[i][j]%10 == 1) count++;
            }
        }
        return count;
    }
}