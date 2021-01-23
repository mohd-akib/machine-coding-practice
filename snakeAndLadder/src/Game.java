import models.*;

public class Game {
    static int current_turn = 0;
    static int WINNER_POSITION = 100;
    Board board;

    public Game(Board board) {
        this.board = board;
    }

    public String play() {
        while (true) {
            int diceValue = Dice.roll();
            Player player = board.getPlayers().get(current_turn);
            int finalPosition = getFinalPosition(player, diceValue);
            System.out.println("Player : " + player.getName()
                    + " rolled a " + diceValue
                    + " and moved from " + player.getPosition() + " to " + finalPosition
            );
            player.setPosition(finalPosition);
            if (player.isWinner(WINNER_POSITION)) return player.getName();
            else current_turn = (current_turn + 1) % board.getPlayers().size();
        }
    }

    private int getFinalPosition(Player player, int diceValue) {
        int finalPosition = player.getPosition() + diceValue;
        if(finalPosition > 100) return player.getPosition();
        while (true) {
            int temp = finalPosition;
            Snake snake = board.getSnakeAt(finalPosition);
            if (snake != null) {
                finalPosition = snake.getEnd();
                System.out.println("Got a bite from snake: " + snake.getStart() + "  " +snake.getEnd());
            }
            Ladder ladder = board.getLadderAt(finalPosition);
            if (ladder != null) {
                finalPosition = ladder.getEnd();
                System.out.println("Whoo got a ladder: " + ladder.getStart() + " " + ladder.getEnd());
            }
            if (temp == finalPosition) break;
        }
        return finalPosition;

    }
}
