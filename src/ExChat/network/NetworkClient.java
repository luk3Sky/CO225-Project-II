package ExChat.network;

import java.io.IOException;
import java.net.Socket;

public class NetworkClient {
    private Socket socket;
    private String ipAddress;
    private int serverPort;

    public NetworkClient(String ipAddress,int serverPort){
        this.ipAddress=ipAddress;
        this.serverPort=serverPort;
    }

    public void connectToServer(){
        try {
            socket = new Socket(ipAddress,serverPort);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        }).start();
    }
}
