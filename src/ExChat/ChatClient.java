package ExChat;

import ExChat.network.NetworkClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatClient extends JFrame {

    public static final String TITLE="Chat Client";
    private static ChatClient instance;

    private JList listUsers;
    private JTextPane txtChat;
    private JTextField fieldInput;
    private JButton btnSend;

    private NetworkClient client;

    public ChatClient(){
        createView();

        client = new NetworkClient("127.0.10.1", 1080);
        client.connectToServer();

        setTitle(TITLE);
        setSize(600,400);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        listUsers = new JList();
        JScrollPane userSP = new JScrollPane(listUsers);
        userSP.setPreferredSize(new Dimension(200,0));
        panel.add(userSP, BorderLayout.EAST);

        JPanel panelChat = new JPanel(new BorderLayout());
        panel.add(panelChat, BorderLayout.CENTER);

        txtChat = new JTextPane();
        txtChat.setEditable(false);
        JScrollPane txtChatPane = new JScrollPane(txtChat);
        panel.add(txtChatPane);

        JPanel panelInput = new JPanel(new BorderLayout());
        panel.add(panelInput, BorderLayout.SOUTH);
        fieldInput = new JTextField();
        panelInput.add(fieldInput, BorderLayout.CENTER);

        btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panelInput.add(btnSend, BorderLayout.EAST);
    }


    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                instance = new ChatClient();
                instance.setVisible(true);
            }
        });
    }
}
