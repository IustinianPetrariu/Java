import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {

    protected Thread thread;
    private String name;
    private Game game;
    private String mode;
    protected int points;

    ///each player will have some tokens that he choose from the board
    protected List<Token> tokens = new ArrayList<>();

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public Player(String name, String mode) {
        this.mode = mode;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean extractTokenFromBoard() throws InterruptedException {
        ///if is not your turn, then wait
        boolean continuePlay = game.turn(this);
        return continuePlay;

    }


    @Override
    public void run() {
        try {
            while (true) {
                if (!Counter.keepRunning)
                    break;
                if (!extractTokenFromBoard())
                    break;

            }

        } catch (InterruptedException expection) {
            expection.printStackTrace();
        }

    }

    public void start() {
        //  System.out.println("Starting" + name);
        if (thread == null) {
            thread = new Thread(this, name);
            thread.start();
        }
    }
}
