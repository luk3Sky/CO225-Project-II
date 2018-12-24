package ExChat;

import javax.swing.*;
import java.awt.*;

public class ChatServer extends JFrame {

    public static final String TITLE="Chat Server";
    private static ChatServer instance;
    private JTextPane console;
    private JList listUsers;

    public ChatServer(){
        createView();

        setTitle(TITLE);
        setSize(500,400);
        setResizable(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void createView(){
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(new BorderLayout());

        console = new JTextPane();
        console.setEditable(false);
        JScrollPane consoleScrollPane = new JScrollPane(console);
        consoleScrollPane.setBorder(BorderFactory.createTitledBorder("Console Output"));
        panel.add(consoleScrollPane, BorderLayout.CENTER);

        listUsers = new JList();
        JScrollPane userScrollPane = new JScrollPane(listUsers);
        userScrollPane.setPreferredSize(new Dimension(200,0));
        userScrollPane.setBorder(BorderFactory.createTitledBorder("Connected Users"));
        panel.add(userScrollPane, BorderLayout.EAST);
    }
    public static ChatServer getInstance() {

        return instance;
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                instance = new ChatServer();
                instance.setVisible(true);
            }
        });
    }
}
