public class Main {

    public static void main(String[] args) {
        System.out.println("all good!");
        /// first, construct a board
        Board board=new Board(5);
        ///second, add some tokens
        board.addToken(new Token(1,2,12));
        board.addToken(new Token(2,3,21));
        board.addToken(new Token(4,5,18));
        board.addToken(new Token(3,4,13));
        board.addToken(new Token(2,1,12));
        Game game= new Game(board);
        //third, add some player
        game.addPlayer(new Player("Ionel"));
        game.addPlayer(new Player("Vasile"));
        game.addPlayer(new Player("Giani"));
        game.start();

    }
}
