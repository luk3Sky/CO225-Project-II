/*  CO225 Project II Auction Server
 *   J.K.C.N.Jayasooriya - E/15/154
 *   A.H.G.D.Jayalath    - E/15/142
 */

package com.foxploit;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends JFrame {
    public static final int BASE_PORT = 2000;   // The base port for the server
    /*
     * UI components
     */
    public static final String TITLE = "Auction Server";
    public static ArrayList<String> historyList = new ArrayList<>();
    public String[] colNames = {"Symbol", "Security Name", "Current Price"};
    public String[] symbol = {"FB", "VRTU", "MSFT", "GOOGL", "YHOO", "XLNX", "TSLA", "TXN"};
    public String[][] data = new String[symbol.length][colNames.length];
    private ServerSocket serverSocket = null;   // Server Socket for main server
    private StockDB stockDatabase;              // Stock database
    private JTextArea txtArea;
    private JTable currentPrice;


    public Server(int socket, StockDB users) {
        this.stockDatabase = users;

        //UI stuff
        createView();
        setTitle(TITLE);
        setSize(500, 400);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            this.serverSocket = new ServerSocket(socket);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(new BorderLayout());


        for (int i = 0; i < symbol.length; i++) {
            data[i][0] = symbol[i];
            data[i][1] = stockDatabase.findSecurityName(symbol[i]);
            data[i][2] = stockDatabase.findSecurityPrice(symbol[i]);
        }

        currentPrice = new JTable(data, colNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane tableSP = new JScrollPane(currentPrice);
        tableSP.setPreferredSize(new Dimension(200, 200));
        tableSP.setBorder(BorderFactory.createTitledBorder("Current Price"));
        panel.add(tableSP, BorderLayout.CENTER);


        txtArea = new JTextArea();
        txtArea.setEditable(false);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.append("No bids have been placed yet\n");

        JScrollPane historySP = new JScrollPane(txtArea);
        historySP.setPreferredSize(new Dimension(200, 200));
        historySP.setBorder(BorderFactory.createTitledBorder("Bid History"));
        panel.add(historySP, BorderLayout.SOUTH);


    }

    public void updateHistory(String msg) {
        txtArea.append(msg + "\n");
    }


    public void updateCol(String sym, String bid) {
        for (int i = 0; i < symbol.length; i++) {
            if (sym.equals(symbol[i])) {
                currentPrice.setValueAt(bid, i, 2);
            }
        }

    }
    /* each server will provide the following functions to
     * the public. Note that these are non-static
     */

    public boolean isAuthorized(String symbol) {
        return this.stockDatabase.findSecuritySymbol(symbol);
    }


    public synchronized void changePrice(String key, String newValue) {
        // should these be synchronized?
        try {
            wait(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stockDatabase.changeSecurityPrice(key, newValue);
        notifyAll();
    }

    /* server will define how the messages should be posted
     * this will be used by the connection servers
     */

    public void addAndDisplayHistory(String msg) {
        // all threads print to same screen
        // Add to the history
        historyList.add(msg);
        System.out.println(historyList);
        System.out.println(msg);
    }

    public String authorizedOnce(String a) {
        // need to implement this.
        return null;
    }

    public void server_loop() {
        try {
            while (true) {
                Socket socket = this.serverSocket.accept();
                Client client = new Client(this);
                client.connectToServer(socket);
                System.out.println("A client has connected." + client);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }// end server_loop

}