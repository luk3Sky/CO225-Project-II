package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TryTextArea extends JFrame {

    private JTextArea txtArea;
    private JButton btnClr;
    private JTextField fieldMsg;
    private JButton btnSubmit;

    public TryTextArea(){
        createView();

        setTitle("Text Area Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,200);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JLabel label = new JLabel("Enter some text: ");
        panel.add(label);

        fieldMsg = new JTextField();
        fieldMsg.setPreferredSize(new Dimension(200,25));
        panel.add(fieldMsg);

        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = fieldMsg.getText();
                txtArea.append(msg+"\n");
                fieldMsg.setText("");
            }
        });
        panel.add(btnSubmit);

        txtArea = new JTextArea();
        txtArea.setEditable(false);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setPreferredSize(new Dimension(350,90));

        JScrollPane scrollPane = new JScrollPane(txtArea);
        panel.add(scrollPane);

        btnClr = new JButton("Clear");
        btnClr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.setText(null);
            }
        });
        panel.add(btnClr);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TryTextArea().setVisible(true);
            }
        });

    }
}
