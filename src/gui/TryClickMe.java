package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TryClickMe extends JFrame {

    private JButton btnCounter, btnReset;
    private JLabel lblCount;

    private int clicks=0;

    public TryClickMe(){
        createView();

        setTitle("Try Click Me");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

        setLocationRelativeTo(null);
        setResizable(false);

    }

    public void createView(){
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        lblCount = new JLabel();
        lblCount.setPreferredSize(new Dimension(200,30));
        panel.add(lblCount);

        updateCounter();

        btnCounter=new JButton("Click Me");
        btnCounter.addActionListener(
                new btnCounterActionListner()
        );
        panel.add(btnCounter);

        btnReset = new JButton("Reset");
        btnReset.addActionListener(
                new btnResetActionListener()
        );
        panel.add(btnReset);


    }

    public void updateCounter(){
        lblCount.setText("Clicked "+ clicks +" times");
    }

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TryClickMe().setVisible(true);
            }
        });
    }

    private class btnCounterActionListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clicks++;
            updateCounter();
        }
    }

    private class btnResetActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clicks=0;
            updateCounter();
        }
    }
}