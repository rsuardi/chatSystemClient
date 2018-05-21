package practice.main;

import practice.repository.Client;

import java.io.IOException;

public class System {

    public static void main(String[] args) {
        try {
            Client client = new Client("cliente",1234,"localhost");
            client.startClient();
            //client.startClient2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
