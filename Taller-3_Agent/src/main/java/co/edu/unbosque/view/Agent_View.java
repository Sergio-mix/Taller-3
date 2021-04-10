package co.edu.unbosque.view;

import co.edu.unbosque.controller.Agent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class Agent_View
 */
public class Agent_View extends JFrame {

    public JTextArea jTextArea;
    public JTextField jTextField;
    public JButton jButton;

    public Agent_View() {

        //JFrame
        setSize(800, 400);
        setUndecorated(true);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Agent");
        setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));

        //JPanel
        JPanel jPanel = new JPanel();
        jPanel.setBackground(new Color(0, 0, 0, 100));
        jPanel.setLayout(null);
        add(jPanel);

        //JTextArea
        jTextArea = new JTextArea();
        jTextArea.setBounds(50, 50, 800, 250);
        jTextArea.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        jTextArea.setForeground(new Color(0, 255, 153, 255));
        jTextArea.setEditable(false);
        jPanel.add(jTextArea);

        //JTextField
        jTextField = new JTextField();
        jTextField.setBounds(50, 320, 500, 40);
        jTextField.setBorder(null);
        jTextField.setBackground(new Color(47, 47, 47));
        jTextField.setForeground(new Color(255, 255, 255));
        jPanel.add(jTextField);

        //jButton
        jButton = new JButton("Enviar");
        jButton.setBounds(600, 320, 150, 40);
        jButton.setBorder(null);
        jButton.setBackground(new Color(255, 255, 255, 255));
        jPanel.add(jButton);

        ActionListener myButtonListener = new Agent();
        jButton.addActionListener(myButtonListener);

    }
}