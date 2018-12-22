package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TryTextInput extends JFrame {

    private JTextField txtField;
    private JLabel lblMsg;
    private JButton btnSubmit;


    public TryTextInput(){
        createView();

        setTitle("Hello :)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,100);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JLabel lblStatic = new JLabel("Enter your name: ");
        panel.add(lblStatic);

        txtField = new JTextField(15);
        txtField.setPreferredSize(new Dimension(300,30));
        panel.add(txtField);

        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtField.getText();
                if (name.isEmpty()){
                    lblMsg.setText("Your name can't simply be nothing isn't id?");
                } else {
                    lblMsg.setText("Hello "+name+", How are you?");
                }
            }
        });
        panel.add(btnSubmit);

        lblMsg = new JLabel("Please Enter your name");
        panel.add(lblMsg);

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TryTextInput().setVisible(true);
            }
        });
    }
}
