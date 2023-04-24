package edu.sdccd.cisc191.template;

import java.net.*;
import java.io.*;

/**
 * The server class listens to port 6000 to establish or
 * accept connection with the client
 */
public class Server {

    /**
     * The listening port where server listens
     */
    public static final int LISTENING_PORT = 6000;

    /**
     * The main method of the server
     * It listens to incoming client request through the listening port
     * It processes the received serialized request form the Client, then
     * deserialized it in order to process the request. After it is done processing the request
     * it will create a deserialized response object.
     * Then it will serialize the response and send it to client
     * @param args the command line argument
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(LISTENING_PORT);
            while (true) {
                Socket socket = serverSocket.accept();

                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

                String status = "Transplant";

                VegetableRequest clientRequest = (VegetableRequest) inputStream.readObject();
                VegetableResponse serverResponse = new VegetableResponse(clientRequest, status);
                outputStream.writeObject(serverResponse);

                socket.close();
                serverSocket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
