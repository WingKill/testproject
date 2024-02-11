import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
            handleClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient() {
        try {
            ArrayList<Post> posts = Server.getPosts();
            outputStream.writeObject(posts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
