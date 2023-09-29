package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DecaServer {

    public static void main(String[] args) throws Exception {
        System.out.println("Client has connected");

        try (
                ServerSocket serverSocket = new ServerSocket(2311);
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));

        ) {
            while (true) {
                String clientMessage = reader.readLine();
                System.out.println("Message from Client [-_-] :: " + clientMessage);
                System.out.println("Please Enter Your Response :: {>_<} :: ");
                String text = keyBoard.readLine();
                writer.println(text);
            }
        }

    }
}
