import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {

    private Thread thread;
    private String name;
    private Game game;
    ///every player will have some tokens that he choose from the board
    private List<Token> tokens = new ArrayList<>();

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean extractTokenFromBoard() throws InterruptedException {
        Token token = game.getBoard().extractToken();
        if (token == null)
            return false;
        this.tokens.add(token);
        System.out.println(name + ":" + "I extracted:" + token.i + "," + token.j);
        // Thread.sleep(100);
        return true;
    }

    @Override
    public void run() {
        //  System.out.println("I started :" + name);
        try {
            while (true) {
                if (!extractTokenFromBoard())
                    break;
            }
        } catch (InterruptedException expection) {
            expection.printStackTrace();
        }
    }

    public void start() {
        System.out.println("Starting" + name);
        if (thread == null) {
            thread = new Thread(this, name);
            thread.start();
        }
    }
}
