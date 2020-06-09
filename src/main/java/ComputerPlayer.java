public class ComputerPlayer {

    Utils utils;
   public ComputerPlayer(Utils util) {
       utils = util;
   }
   public int minMax(char[][] board, int depth, boolean isMax){
       int score = utils.score(board);
       if (score == 10){
           return score-depth;
       }
       if (score == -10){
           return score + depth;
       }
       if (!utils.hasMovesLeft(board)){
           return 0;
       }
       if(isMax){
           int best = -10000;
           for(int i = 0; i < board.length; i++){
               for(int j = 0; j < board.length; j++){
                   if (board[i][j] == '_'){
                       board[i][j] = 'x';
                       best = Math.max(minMax(board, depth+1, !isMax), best);
                       board[i][j] = '_';

                   }
               }

           }
           return best;
       }else{
           int best = 10000;
           for(int i = 0; i < board.length; i++){
               for(int j = 0; j < board.length; j++){
                   if (board[i][j] == '_'){
                       board[i][j] = 'o';
                       best = Math.min(minMax(board, depth+1, !isMax), best);
                       board[i][j] = '_';
                   }
               }
           }
           return best;
       }


   }
   public int findBest(char[][] board){
        int bestScore = 10000;
        int bestLocation = 0;
       for(int i = 0; i < board.length; i++){
           for(int j = 0; j < board.length; j++){
               if (board[i][j] == '_'){
                   board[i][j] = 'o';
                   int moveVal = minMax(board, 0, true);
                   board[i][j] = '_';
                   if (moveVal < bestScore){
                       bestLocation = i*3+ j;
                   }
               }
           }
       }
        return bestLocation;
   }

}
