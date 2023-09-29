package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DecaClient {

    public static void main(String[] args) throws Exception {

        System.out.println("Connected to server successfully..");
        try (
                Socket socket = new Socket("localhost",2311 );
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader keyBoard = new BufferedReader(new InputStreamReader(System.in));
        )
        {

            while (true) {
                System.out.println("Message Server :: {>_<} :: ");
                String text = keyBoard.readLine();
                writer.println(text);

                String serverMessage = reader.readLine();
                System.out.println("Message from Server [-_-] :: " + serverMessage);
            }
        }
    }
}
