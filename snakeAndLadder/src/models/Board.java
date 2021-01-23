package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    List<Snake> snakes = new ArrayList<>();
    List<Ladder> ladders = new ArrayList<>();
    List<Player> players = new ArrayList<>();

    public Snake getSnakeAt(int position) {
        for (Snake snake : this.snakes) {
            if(snake.start == position) {
                return snake;
            }
        }
        return null;
    }

    public Ladder getLadderAt(int position) {
        for(Ladder ladder : this.ladders) {
            if(ladder.start == position) return ladder;
        }
        return null;
    }
}
