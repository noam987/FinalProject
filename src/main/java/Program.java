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
        System.out.println("Welcome to Tic-tac-toe. Do you have 2 players?");
        if (console.next().toLowerCase().equals("y")) {
            twoPlayerGame(console);
        }

    }
    public static void twoPlayerGame(Scanner console){
        Board board = new Board('a', 'b');
        int move;
        do{
            System.out.print(board.toString());
            move = console.nextInt();
            board.move(move);
            System.out.println(board.hasWon());

        }while(board.hasWon() == '!');
        if (board.hasWon() == 'd'){
            System.out.print("the game is a draw");
        }
        else if (board.hasWon() == 'a'){
            System.out.print("player one has won");
        }
        else if (board.hasWon() == 'b'){
            System.out.print("player two has won");
        }
    }


}
