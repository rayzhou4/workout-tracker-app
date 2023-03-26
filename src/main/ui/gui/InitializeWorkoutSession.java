package ui.gui;

import javax.swing.*;

public class InitializeWorkoutSession extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton ADDButton;
    private JPanel mainPanel;

    public InitializeWorkoutSession() {
        setFrame();
    }

    public void setFrame() {
        setContentPane(mainPanel);
        setTitle("Workout Tracker");
        setSize(400,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
