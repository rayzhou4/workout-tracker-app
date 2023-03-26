package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main Graphical User Interface class
public class WorkoutAppGUI extends JFrame {

    private JFrame frame;
    //private BookShelfGUI bookShelfPanel = new BookShelfGUI();
    //private ReadingListGUI readingListPanel = new ReadingListGUI();
    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    protected static CardLayout cardLayout = new CardLayout();
    private JButton saveLoadButton;
    private JButton viewWorkoutHistoryButton;
    private JButton addWorkoutSessionButton;
    private JButton viewStatisticsButton;
    private JPanel mainPanel;

    public WorkoutAppGUI() {
        startApp();
    }

    private void setFrame() {
        setContentPane(mainPanel);
        setTitle("Workout Tracker");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        addWorkoutSessionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InitializeWorkoutSession();
            }
        });
    }


    private void startApp() {
        setFrame();
    }
}
