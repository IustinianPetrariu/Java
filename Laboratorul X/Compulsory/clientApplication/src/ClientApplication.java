import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientApplication {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 8081;
    private static Socket socket = null;
    public static Boolean keepRunning = false;
    public BufferedReader in;
    public PrintWriter out;

    public ClientApplication() {
        try {
            socket = new Socket(SERVER_ADDRESS, PORT);
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void sendRequest(String request) {
        ///sending the request to the server
        out.println(request);
        out.flush();

    }

    public String getResponse() throws IOException {

        return in.readLine();

    }

    public static void main(String[] args) {
        ClientApplication clientApplication = new ClientApplication();
        ClientApplication.keepRunning = true;
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (ClientApplication.keepRunning) {
            try {
                ///send a request to the server
                System.out.println("Enter request: ");
                String request = bufferedReader.readLine();
                System.out.println("send to the server the request: ");
                System.out.println(request);
                clientApplication.sendRequest(request);
                if (request.equals("exit")) {
                    System.out.println("shutdown..");
                    ClientApplication.keepRunning = false;
                    clientApplication.in.close();
                    clientApplication.out.close();
                }
                else if (request.equals("stop")) {
                    System.out.println("The server will be stopped!");
                    ClientApplication.keepRunning = false;
                    clientApplication.in.close();
                    clientApplication.out.close();
                } else {
                    ///Wait for the response from the server
                    System.out.println("receive response the from server: ");
                    String response = clientApplication.getResponse();
                    if (response.equals("disconnected")) {
                        System.out.println("You've been disconnected for inactivity..");
                        ClientApplication.keepRunning = false;
                        clientApplication.in.close();
                        clientApplication.out.close();
                    }
                    if (response.equals("server stopped!")) {
                        ClientApplication.keepRunning = false;
                        clientApplication.in.close();
                        clientApplication.out.close();
                    }
                    System.out.println(response);
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        }

    }


}
