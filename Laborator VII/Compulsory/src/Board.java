import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board {

    private int numberOfTokens;
    private boolean available = false;
    private List<Token> tokens = new ArrayList<>();

    public Board(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
    }

    public void setNumberOfTokens(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public synchronized Token extractToken() {

        if (tokens.size() > 0) {
            int randomIndex = (int) (Math.random() * 100) % tokens.size();
            Token token = tokens.get(randomIndex);
            tokens.remove(randomIndex);
            notifyAll();
            return token;
        } else {
            notifyAll();
            return null;
        }
    }
}
