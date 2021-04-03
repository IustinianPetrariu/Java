import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Board {

    private int numberOfTokens;
    static boolean available = false;
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

    public void addToken() {

        for (int i = 0; i < numberOfTokens; i++)
            for (int j = 0; j < numberOfTokens; j++)
                if (i != j)
                    tokens.add(new Token(i, j, i + j));

    }

    public synchronized Token extractTokenManual() {
        if (tokens.size() > 0) {
            available = false;
            while (available == false) {
                System.out.println("Introduceti doua coordonate i j pentru token: ");
                System.out.flush();
                Scanner scan = new Scanner(System.in);
                int x_i = scan.nextInt();
                int x_j = scan.nextInt();
                for (int i = 0; i < tokens.size(); i++)
                    if (tokens.get(i).i == x_i && tokens.get(i).j == x_j) /// if I find a token that I want then
                    {
                        available = true;
                        Token token = tokens.get(i);
                        tokens.remove(i);
                        notifyAll();
                        return token;
                    }
                System.out.println("It seems that token that you want is not available");
                System.out.flush();
            }
        } else {
            notifyAll();
            return null;
        }
        return null;
    }

    public synchronized Token extractTokenRandom(Player player) {
        Token token = null;
        if (tokens.size() > 0) {
            int randomIndex = (int) (Math.random() * 100) % tokens.size();
            token = tokens.get(randomIndex);
            tokens.remove(randomIndex);
            notifyAll();
            return token;
        } else {
            notifyAll();
            return null;
        }
    }
}
