import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> playerList = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void addPlayer(Player player) {
        playerList.add(player);
        player.setGame(this);
    }

    ///Now we want to start all the threads
    public void start() {
        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).start();
        }
    }

}
