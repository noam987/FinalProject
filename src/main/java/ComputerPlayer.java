public class ComputerPlayer {
    Utils utils;
   public ComputerPlayer(Utils util) {
       utils = util;
   }

    /**recursive method that finds the optimal path of moves.
     * uses alpha and beta to minimize the number of loops.
     *
     * @param board board to place moves on
     * @param depth how many moves have been played
     * @param isMax whether the player is the maximizer
     * @param alpha the jighest value found so far
     * @param beta the lowest value found so far
     * @return the score of the position
     */
   public int minMax(char[][] board, int depth, boolean isMax, int alpha, int beta){
       //exit conditions
       int score = utils.score(board);
       if (score > 0){
           return score-depth;
       }
       if (score < 0){
           return score + depth;
       }
       if (!utils.hasMovesLeft(board)){
           return 0;
       }
       int best;
       // checks which player is moving
       if(isMax){
           best = -10000;
           //loops through all available spaces.
           for(int i = 0; i < board.length; i++){
               for(int j = 0; j < board.length; j++){
                   if (board[i][j] == '-') {
                       board[i][j] = 'x';
                       best = Math.max(minMax(board, depth + 1, false, alpha, beta), best);
                       board[i][j] = '-';
                       alpha = Math.max(alpha, best);
                       // Alpha Beta Pruning
                       if (beta <= alpha) {
                           i = board.length;
                           j = board.length;
                       }
                       }
               }

           }
       }else{
           best = 10000;
           //loops through all available spaces.
           for(int i = 0; i < board.length; i++) {
               for (int j = 0; j < board.length; j++) {
                   if (board[i][j] == '-') {
                       board[i][j] = 'o';
                       best = Math.min(minMax(board, depth + 1, true, alpha, beta), best);
                       board[i][j] = '-';
                       beta = Math.min(beta, best);
                       //alpha beta pruning
                       if (beta <= alpha) {
                           i = board.length;
                           j = board.length;
                       }
                   }
               }
           }
       }
       return best;


   }

    /**Finds the best move for a given player on a board.
     *
     * @param board board object to find the best move for
     * @param isMax wheter the best move is for the maximizer or the minimizer
     * @return the location of the best move
     */
   public int findBest(char[][] board, boolean isMax){
       int bestLocation = 0;
       if(isMax) {
           int bestScore = -10000;
            // loops through each empty position
           for (int i = 0; i < board.length; i++) {
               for (int j = 0; j < board.length; j++) {
                   if (board[i][j] == '-') {
                       //place their piece and saves it if it has the best (highest) score so far
                       board[i][j] = 'x';
                       int moveVal = minMax(board, 0, false, -1000, 1000);
                       board[i][j] = '-';
                       if (moveVal > bestScore) {
                           bestLocation = i * board.length + j;
                           bestScore = moveVal;
                       }
                   }
               }
           }
       }else {
           int bestScore = 10000;

           for (int i = 0; i < board.length; i++) {
               for (int j = 0; j < board.length; j++) {
                   if (board[i][j] == '-') {
                       //place their piece and saves it if it has the best (lowest) score so far
                       board[i][j] = 'o';
                       int moveVal = minMax(board, 0, true, -1000, 1000);
                       board[i][j] = '-';
                       if (moveVal < bestScore) {
                           bestLocation = i * board.length + j;
                           bestScore = moveVal;

                       }
                   }
               }
           }
       }


        return bestLocation;
   }

}
