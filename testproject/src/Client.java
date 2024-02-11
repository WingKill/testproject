import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 12345;

    public static void main(String[] args) {
    	try (Socket socket = new Socket(SERVER_IP, PORT);
             ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
            ArrayList<Post> posts = (ArrayList<Post>) inputStream.readObject();
            // 게시글 데이터를 처리하는 로직 작성
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
