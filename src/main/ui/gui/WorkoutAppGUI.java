package ui.gui;

import ui.gui.frames.FileActionsGUI;
import ui.gui.frames.SetWorkoutSessionGUI;
import ui.gui.frames.StatisticsGUI;
import ui.gui.frames.WorkoutHistoryGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Workout Tracker application for GUI
public class WorkoutAppGUI extends JFrame {
    private JButton saveLoadButton;
    private JButton viewWorkoutHistoryButton;
    private JButton addWorkoutSessionButton;
    private JButton viewStatisticsButton;
    private JPanel mainPanel;
    private JLabel image;

    // MODIFIES: this
    // EFFECTS: runs the workout application
    public WorkoutAppGUI() {
        startApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void startApp() {
        setFrame();

        addWorkoutSessionButtonActionListener();
        viewWorkoutHistoryButtonActionListener();
        saveLoadButtonActionListener();
        viewStatisticsButtonActionListener();
    }

    // MODIFIES: this
    // EFFECTS: sets the frame for the GUI
    private void setFrame() {
        setContentPane(mainPanel);
        setTitle("Workout Tracker");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: action listener method for the add workout session button; opens the SetWorkoutSessionGUI
    private void addWorkoutSessionButtonActionListener() {
        addWorkoutSessionButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability to set workout sessions and to eventually add workout sessions
            @Override
            public void actionPerformed(ActionEvent e) {
                new SetWorkoutSessionGUI();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: action listener method for the view workout history button; opens the WorkoutHistoryGUI
    private void viewWorkoutHistoryButtonActionListener() {
        viewWorkoutHistoryButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability to view the workout history
            @Override
            public void actionPerformed(ActionEvent e) {
                new WorkoutHistoryGUI();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: action listener method for the save load button; opens the FileActionsGUI
    private void saveLoadButtonActionListener() {
        saveLoadButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability to open the saving and loading page
            @Override
            public void actionPerformed(ActionEvent e) {
                new FileActionsGUI();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: action listener method for the view statistics button; opens the StatisticsGUI
    private void viewStatisticsButtonActionListener() {
        viewStatisticsButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability to open the saving and loading page
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatisticsGUI();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: creates a new icon
    private void createUIComponents() {
        image = new JLabel(new ImageIcon("data/Images/icon.jpg"));
    }
}
