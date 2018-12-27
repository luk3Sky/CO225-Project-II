package ExChat.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {

    private ServerSocket socket;
    private boolean running = false;
    private int port;

    public NetworkServer(int port){
        this.port=port;

    }

    public void startServer(){
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running){
                    try {
                        Socket client = socket.accept();
                        System.out.println("A client has connected: "+client);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        running = true;
    }

    public void stopServer(){
        running = false;
    }
}
