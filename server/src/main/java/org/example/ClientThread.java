package org.example;

import java.io.*;
import java.net.Socket;

public class ClientThread implements Runnable {
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public ClientThread(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (clientSocket.isConnected()) {
                int message = in.readInt();
                System.out.println("Получено сообщение: " + message);
                String response = switch (message) {
                    case 0 -> "Ноль";
                    case 1 -> "Один";
                    case 2 -> "Два";
                    case 3 -> "Три";
                    case 4 -> "Четыре";
                    case 5 -> "Пять";
                    case 6 -> "Шесть";
                    case 7 -> "Семь";
                    case 8 -> "Восемь";
                    case 9 -> "Девять";
                    case 10 -> "Десять";
                    default -> "Неверное значение";
                };
                System.out.println("Ответ: " + response);
                out.writeUTF(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
