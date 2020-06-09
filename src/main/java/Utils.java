public class Utils {
    public int score(char[][] board){
        char p1 = 'x';
        char p2 = 'o';
        for(int i = 0; i <3; i++){
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]){
                if(board[i][i] == p1){
                    return 10;
                }
                else if(board[i][i] == p2){
                    return -10;
                }
            }
        }
        for(int i = 0; i <3; i ++){
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                if (board[i][i] == p1) {
                    return 10;
                } else if (board[i][i] == p2) {
                    return -10;
                }
            }
        }
        if((board[0][0] == board[1][1] && board[0][0] == board[2][2]) || (board[0][2] == board[1][1] && board[0][2] == board[2][0])){
            if( board[1][1] == p1){
                return 10;
            }else if(board[1][1] == p2){
                return -10;
            }
        }

        return 0;
    }
    public boolean hasMovesLeft(char[][] board){
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == '_'){
                    return true;
                }
            }
        }
        return false;
    }
}
