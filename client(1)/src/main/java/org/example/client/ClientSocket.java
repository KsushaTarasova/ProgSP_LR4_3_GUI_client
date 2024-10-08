package org.example.client;

import java.io.*;
import java.net.Socket;

public class ClientSocket {
    private static final ClientSocket SINGLE_INSTANCE = new ClientSocket();
    private static Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private ClientSocket() {
        try {
            socket = new Socket("localhost", 5555);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
    }

    public static ClientSocket getInstance() {
        return SINGLE_INSTANCE;
    }

    public Socket getSocket() {
        return socket;
    }

    public DataInputStream getIn() {
        return in;
    }

    public DataOutputStream getOut() {
        return out;
    }
}
