package gui;

import javax.swing.*;
import java.awt.*;

public class GeneralGUIBuilding {

    public static void main(String[] args){
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        frame.getContentPane().add(panel);

        JButton btn = new JButton("Click");
        panel.add(btn);

        JTextField txtField = new JTextField();
        txtField.setPreferredSize(new Dimension(200,24));
        panel.add(txtField);

        frame.setSize(new Dimension(500,400));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("A Simple Program");
        frame.setResizable(false);
        frame.setVisible(true);
    }
}