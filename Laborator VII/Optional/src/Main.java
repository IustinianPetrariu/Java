public class Main {

    public static void main(String[] args) {
        System.out.println("all good!");
        /// first, construct a board
        Board board = new Board(5);
        board.addToken();
        Game game = new Game(board);
        /// second, add some types of players
        game.addPlayer(new Player("Player 0", "manual"));
        game.addPlayer(new Player("Player 1", "boot"));
        game.addPlayer(new Player("Player 2", "boot"));
        /// third, start the clock and set it
        ///before start the game, run the daemon
        Counter counter = new Counter(60);
        counter.setDaemon(true);
        counter.start();
        game.start();

    }
}
