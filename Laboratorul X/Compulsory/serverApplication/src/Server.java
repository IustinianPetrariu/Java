import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 8081;
    private ServerSocket serverSocket;
    private boolean keepRunning = false;


    /// try to start the server
    public void initialize() {
        try {
            this.serverSocket = new ServerSocket(PORT);
            this.keepRunning = true;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    ///serve the clients
    public void start() {
        try {

            while (this.keepRunning) {
                System.out.println("Waiting for clients..");
                Socket socket = serverSocket.accept();
                if (this.keepRunning) {
                    ///if the client arrive, we make a new thread to serve him
                    new ClientThread(this, socket).start();
                }

            }

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (java.io.IOException exc) {
                exc.printStackTrace();
            }
        }
    }

    public void stop() {
        this.keepRunning = false;
        ///wait for the threads that are already started to finish their job

        while (true) {
            int livesThread = 1;
            for (Thread thread : Thread.getAllStackTraces().keySet()) {
                if (thread.getState() == Thread.State.RUNNABLE) {
                    livesThread = 0;
                }
            }
            if (livesThread == 1)
                break;
        }
        try {
            this.serverSocket.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }


    }


}