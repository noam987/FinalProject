import java.awt.*;
import java.util.Scanner;
import javax.swing.JFrame;

public class Program extends Canvas {
    public static void main(String[] args) {
//        JFrame frame = new JFrame("My Drawing");
//        Canvas canvas = new Program();
//        canvas.setSize(400, 400);
//        frame.add(canvas);
//        frame.pack();
//        frame.setVisible(true);
        Scanner console = new Scanner(System.in);
        Utils utils = new Utils();
        System.out.println("Welcome to Tic-tac-toe. Do you have 2 players?");
        String mode = console.next().toLowerCase();
        if (mode.equals("y")) {
            twoPlayerGame(console, utils);
        }
        if (mode.equals("n")) {
            onePlayerGame(console, utils);
        }



    }
    public static void twoPlayerGame(Scanner console, Utils utils){
        Board board = new Board('x', 'o');
        int move;
        do{
            System.out.print(board.toString());
            move = console.nextInt();
            board.move(move);
            System.out.println(utils.score(board.getBoard()));

        }while(utils.hasMovesLeft(board.getBoard()) && utils.score(board.getBoard()) == 0);
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
    private static void onePlayerGame(Scanner console, Utils utils){
        Board board = new Board('x', 'o');
        ComputerPlayer ai = new ComputerPlayer(utils);
        int move;
        do{
            System.out.println(board.toString());
            move = console.nextInt();
            board.move(move);
            System.out.println(board.toString());
            board.move(ai.findBest(board.getBoard()));
        }while(utils.hasMovesLeft(board.getBoard()) || utils.score(board.getBoard()) != 0);
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
