import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    public List<Player> playerList = new ArrayList<>();
    public static int turn;
    public static List<String> names;

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

    public synchronized boolean turn(Player player) {
        while (player.getGame().playerList.indexOf(player) != Game.turn) {
            try {
                wait();
            } catch (InterruptedException expection) {
                expection.printStackTrace();
            }
        }
        Game.turn = Game.turn - 1;
        if (Game.turn < 0)
            Game.turn = 2;
        Token token = null;
        if (player.getMode() == "manual") {
            System.out.println("{ " + player.getName() + " } is Manual, you have to guide him");
            System.out.flush();
            token = getBoard().extractTokenManual();
        } else
            token = getBoard().extractTokenRandom(player);
        if (token == null) {
            notifyAll();
            return false;
        }
        player.tokens.add(token);
        System.out.println(player.getName() + " ( " + player.getMode() + " ) : " + "extracted:" + token.i + "," + token.j);
        System.out.flush();
        notifyAll();
        return true;

    }

    ///Now we want to start all the threads
    public void start() {
        ///first, start the thread to play the game
        Game.turn = playerList.size() - 1;
        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).start();
        }
        /// second, wait for players to finish the game
        for (int i = 0; i < playerList.size(); i++) {
            try {
                playerList.get(i).thread.join();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

        }

        /// calculate the points: see if the player has a closed sequence
        /// and for each token from that sequence, sum the values of tokens
        for (int i = 0; i < playerList.size(); i++) {
            int wrong = 0;
            if (playerList.get(i).tokens.size() > 0) {
                Token firstToken = playerList.get(i).tokens.get(0);
                Token lasttToken = playerList.get(i).tokens.get(playerList.get(i).tokens.size() - 1);
                if (firstToken.i != lasttToken.j)
                    playerList.get(i).points = 0;
                else {
                    for (int j = 0; j < playerList.get(i).tokens.size() - 1; j++) {
                        Token token1 = playerList.get(i).tokens.get(j);
                        Token token2 = playerList.get(i).tokens.get(j + 1);
                        if (token1.j != token2.i) {
                            wrong = 1;
                            playerList.get(i).points = 0;
                            break;
                        } else {
                            playerList.get(i).points += token1.value;
                        }
                    }
                }
            } else
                playerList.get(i).points = 0;
        }
        /// third, determine who the winner is at the end of the game
        System.out.println("ok, now all players finish the game, let's see the results");
        int maxim = 0;
        int index = 0;
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).points >= maxim) {
                maxim = playerList.get(i).points;
                index = i;
            }
        }
        System.out.println("the winner is :");
        System.out.println(playerList.get(index).getName());

        /// third: once they finished the game, implement the scoring
        /// and determine who is the winner
    }

}
