import models.Board;
import models.Ladder;
import models.Player;
import models.Snake;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Board board = new Board();
        setup(board);
        Game game = new Game(board);
        System.out.println("Winner : " + game.play());
    }

    public static void setup(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of snakes");
        int snakes = sc.nextInt();
        int i=0;
        while(i < snakes) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            Snake snake = new Snake(start, end);
            board.getSnakes().add(snake);
            i++;
        }
        i = 0;
        System.out.println("Enter no. of ladders");
        int ladders = sc.nextInt();
        while (i< ladders) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            Ladder ladder = new Ladder(start, end);
            board.getLadders().add(ladder);
            i++;
        }

        System.out.println("Enter no. of players");
        int noOfPlayers = sc.nextInt();
        i = 0;
        while(i < noOfPlayers) {
            System.out.println("Enter player name:");
            String name = sc.next();
            Player p = new Player(name);
            board.getPlayers().add(p);
            i++;
        }
    }
}
