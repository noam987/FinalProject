public class Board {
    private char player1;
    private char player2;
    private int turn = 0;
    private char[][] board;
    public Board(char p1, char p2){
        board = new char[3][3];
        player1 = p1;
        player2 = p2;
        for(char[] line: board){
            for(int i = 0; i < board.length; i++){
                line[i] = '-';
            }
        }
    }

    /**
     *
     * @param space place the next piece in this location
     * @return 'o' if out of range, 'k' if the move worked, and 't' if the move is taken
     */
    public char move(int space){
        if(board.length == 3) {
            if (space > 8 || space < 0) {
                return 'o';
            }
            // checks if the move is taken
            if (board[space / 3][space % 3] == '-') {
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
        }

        return 't';
    }
    public char[][] getBoard(){
        return board;
    }
    public String toString(){
        String output = "";

        for(int i = 0; i < board.length; i ++){

            for(int j = 0; j < board.length -1; j++){
                output+= board[i][j] + "|";
            }
            output += board[i][board.length-1]+"\n";
            if(i < board.length-1){
                output+= "_____\n";
            }
        }

        return output;
    }
}
