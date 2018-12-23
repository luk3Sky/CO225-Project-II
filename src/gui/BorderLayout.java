package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderLayout extends JFrame {
    private JButton btnSubmit,btnClr;
    private JTextField fieldMsg;
    private JTextArea txtArea;

    public BorderLayout(){
        createView();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,200);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    private void createView() {
        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panel);

        JPanel panelNorth = new JPanel(new java.awt.BorderLayout());
        panel.add(panelNorth, java.awt.BorderLayout.NORTH);

        panelNorth.add(new JLabel("Enter a text: "), java.awt.BorderLayout.WEST);

        fieldMsg = new JTextField();
        panelNorth.add(fieldMsg, java.awt.BorderLayout.CENTER);

        btnSubmit = new JButton("Submit");
        panelNorth.add(btnSubmit, java.awt.BorderLayout.EAST);

        txtArea = new JTextArea();
        txtArea.setEditable(false);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(txtArea);
        panel.add(scrollPane);

        JPanel panelSouth = new JPanel();
        panel.add(panelSouth, java.awt.BorderLayout.SOUTH);

        btnClr = new JButton("Clear");
        panelSouth.add(btnClr);

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BorderLayout().setVisible(true);
            }
        });
    }
}
