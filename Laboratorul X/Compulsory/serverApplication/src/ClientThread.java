import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class ClientThread extends Thread {
    private Socket socket = null;
    private Server server;
    public boolean keepRunning = true;

    public ClientThread(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }

    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            socket.setSoTimeout(1000*60);
            while (keepRunning) {

                /// read the message from client
                String request = in.readLine();
                ///execute the command from client
                String response = execute(request);

                if (response != null) {
                    ///give a response to the client
                    out.println(response);
                    out.flush();
                }
            }

        } catch (SocketTimeoutException exception) {
            /// if client doesn t respond then the server will terminate the connection
            System.out.println("[server]: Client isn't active, I will close the connection");
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println("disconnected");
                out.flush();
                keepRunning = false;
            } catch (IOException exception1) {
                exception.printStackTrace();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private String execute(String request) {
        String response;
        System.out.println("Server received the request: " + request);
        if (request.equals("exit")) {
            keepRunning = false;
            return null;
        }
        if (request.equals("stop")) {
            System.out.println("server will shutdown..no more clients are allowed");
            System.out.flush();
            keepRunning = false;
            server.stop();
            return null;

        }
        response = "hello from server";
        return response;

    }

}
