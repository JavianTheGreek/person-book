package com.application.view;

import com.application.model.Person;
import com.application.model.PersonTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;
import java.util.Random;

public class PersonBookView extends JFrame implements ActionListener {

    public static Random rand = new Random();// Random generator object
    private JFrame frame;
    private JLabel lblh1, lblh2, lblh3, lblp1, lblp2, lblp3, lblspan, panel;
    private JTextField txtbox1;
    private JButton btn1, btn2, btn3;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitMenuItem;
    Person person;
    PersonTree personTree;

    PersonBookView(){
        super("");

        setWindowProperties();
    }

    public void initializeComponents() {
        panel = new JLabel("Customer Database");
        panel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        panel.setBounds(140, 30, 350, 30);


    }

    public void addToPanel() {
        add(panel);
    }

    public void setWindowProperties() {
        setSize(800, 600);
        setLayout(null);
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == exitMenuItem) {
        JOptionPane.showMessageDialog(frame, "");
        this.dispose();
    }

    }
}
