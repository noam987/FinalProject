public class Board {
    private char player1;
    private char player2;
    private int turn = 0;
    private char[][] board = new char[3][3];
    public Board(char p1, char p2){
        player1 = p1;
        player2 = p2;
        for(char[] line: board){
            for(int i = 0; i < 3; i++){
                line[i] = '_';
            }
        }
    }
    public char move(int space){
        if(space>8 || space <0){
            return 'o';
        }
        if(board[space/3][space%3] == '_') {
            char player;
            if (turn % 2 == 0) {
                player = player1;
            } else {
                player = player2;
            }
            board[space / 3][space % 3] = player;
            turn++;
            return 'k';
        }
        else return 't';
    }
    public char[][] getBoard(){
        return board;
    }
    public String toString(){
        String output = "";
        output += "________\n";
        for(char[] line: board){
            output+="|";
            for(char piece: line){
                output+= piece + "|";
            }
            output += "\n________\n";
        }
        return output;
    }
    public char hasWon(){
        for(int i = 0; i <3; i++){
            if(board[i][i] != '_'&&board[i][0] == board[i][1] && board[i][0] == board[i][2]&&board[0][i] == board[1][i] && board[0][i] == board[2][i]){
                return board[i][i];
            }
        }
        for(int i = 0; i <3; i ++){
            for(int j = 0; j <3; j ++){
                if(board[i][j] == '_'){
                    return '!';
                }

            }
        }
        return 'd';
    }
}
