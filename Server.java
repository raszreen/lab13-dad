package exercise3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
public class Server {
    public static void main(String[] args) throws IOException {
        // Create a server socket.
    	Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
        // Listen for clients.
        while (true) {
            // Accept a client connection.
            //Socket socket = socket.accept();
            // Get the input and output streams from the socket.
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            // Read the text from the client.
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            // Convert the bytes to a string.
            String text = new String(buffer, 0, bytesRead);
            // Count the words in the text.
            int wordCount = countWords(text);
            // Send the word count to the client.
            outputStream.write(String.valueOf(wordCount).getBytes());
            // Close the socket.
            socket.close();
        }
    }
    private static int countWords(String text) {
        // Split the text into words.
        String[] words = text.split(" ");
        // Count the number of words.
        int wordCount = words.length;
        return wordCount;
    }
}
