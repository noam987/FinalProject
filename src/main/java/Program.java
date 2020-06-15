import java.awt.*;
import java.util.Scanner;
import javax.swing.JFrame;

public class Program extends Canvas {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Utils utils = new Utils();
        do {
            System.out.println("Welcome to Tic-tac-toe. Press \"y\" for two player game, \"n\" for single player game, or \"z\" for ai vs ai game.");
            String mode = console.next().toLowerCase();
            if (mode.equals("y")) {
                twoPlayerGame(console, utils);
            }
            if (mode.equals("n")) {
                onePlayerGame(console, utils);
            }
            if (mode.equals("z")) {
                aiGame(utils);
            }
                System.out.println("do yo want to play again? (y/n)");
        }while(console.next().toLowerCase().equals("y"));

    }

    /**plays through a game with both inputs being from the console.
     *
     * @param console the input scanner for the player moves
     * @param utils a utils class to determine the score of the board and if there are more moves.
     */
    public static void twoPlayerGame(Scanner console, Utils utils){

        Board board = new Board('x', 'o');
        System.out.println("The first player is x the second player is o");
        System.out.println("the top left corner is 0, the bottom right is 8");
        System.out.println("one square right is +1, one square down is +3");
        int move;
        do{
            System.out.print(board.toString());
            move = console.nextInt();
            char code = board.move(move);
            //sends a message if the move is not valid.
            if (code == 'o'){
                System.out.println("your selected  move is out of range");
            }
            if(code == 't'){
                System.out.println("your selected  move is already taken");
            }

        }while(utils.hasMovesLeft(board.getBoard()) && utils.score(board.getBoard()) == 0);
        System.out.println(board.toString());
        //end game message
        if (utils.score(board.getBoard()) == 0){
            System.out.print("the game is a draw");
        }
        else if (utils.score(board.getBoard()) == 10){
            System.out.print("player one has won");
        }
        else if (utils.score(board.getBoard()) == -10){
            System.out.print("player two has won");
        }
    }
    /**plays through a game with one inputs being from the console and the other from the AI.
     *
     * @param console the input scanner for the player moves
     * @param utils a utils class to determine the score of the board and if there are more moves.
     */
    private static void onePlayerGame(Scanner console, Utils utils){
        Board board = new Board('x', 'o');
        ComputerPlayer ai = new ComputerPlayer(utils);
        //introduction
        System.out.println("do you want to go first?");
        System.out.println("The first player is x the second player is o");
        System.out.println("the top left corner is 0, the bottom right is 8");
        System.out.println("one square right is +1, one square down is +3");
        String mode = console.next().toLowerCase();
        int turn = 0;
        if (mode.equals("y")) {
            int move;
            do {
                System.out.println(board.toString());
                //players turn
                if (turn % 2 == 0) {
                    move = console.nextInt();
                    char code =board.move(move);
                    if (code == 'o'){
                        System.out.println("your selected  move is out of range");
                    }
                    else if(code == 'k'){
                        System.out.println("your selected  move is already taken");
                    }else{
                        turn++;}
                } else {
                    //computers turn as the minimizer
                    board.move(ai.findBest(board.getBoard(), false));
                    turn++;
                }
            } while (utils.hasMovesLeft(board.getBoard()) && utils.score(board.getBoard()) == 0);
        }else{
            int move;
            do {
                if (turn % 2 == 1) {
                    //players turn
                    System.out.println(board.toString());
                    move = console.nextInt();
                    char code =board.move(move);
                    if (code == 'o'){
                        System.out.println("your selected  move is out of range");
                    }
                    else if(code == 'k'){
                        System.out.println("your selected  move is already taken");
                    }else{
                    turn++;}
                } else {
                    //computers turn as the maximizer.
                    System.out.println(board.toString());
                    board.move(ai.findBest(board.getBoard(), true));
                    turn++;
                }
            } while (utils.hasMovesLeft(board.getBoard()) && utils.score(board.getBoard()) == 0);

        }
        //endgame message
        System.out.println(board.toString());
        if (utils.score(board.getBoard()) == 0){
            System.out.print("the game is a draw");
        }
        else if (utils.score(board.getBoard()) > 0){
            System.out.print("player one has won");
        }
        else if (utils.score(board.getBoard()) < 0){
            System.out.print("player two has won");
        }
    }
    /**
        Creates a game with two computer players.
     @param utils a utils class to determine the score of the board and if there are more moves.
     */
    public static void aiGame(Utils utils){
        Board board = new Board('x', 'o');
        ComputerPlayer ai = new ComputerPlayer(utils);
        int turn = 1;
        board.move(board.getBoard().length/2 *board.getBoard().length +board.getBoard().length/2);

        do {
            System.out.println(board.toString());
            if (turn % 2 == 1) {
                board.move(ai.findBest(board.getBoard(), false));
            } else {
                board.move(ai.findBest(board.getBoard(), true));
            }
            turn++;
        } while (utils.hasMovesLeft(board.getBoard()) && utils.score(board.getBoard()) == 0);
        System.out.println(board.toString());
        if (utils.score(board.getBoard()) == 0){
            System.out.print("the game is a draw");
        }
        else if (utils.score(board.getBoard()) > 0){
            System.out.print("player one has won");
        }
        else if (utils.score(board.getBoard()) < 0){
            System.out.print("player two has won");
        }

    }

}
