package ui.gui;

import model.Event;
import model.EventLog;
import ui.gui.frames.FileActionsGUI;
import ui.gui.frames.SetWorkoutSessionGUI;
import ui.gui.frames.StatisticsGUI;
import ui.gui.frames.WorkoutHistoryGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

// Workout Tracker application for GUI
public class WorkoutAppGUI extends JFrame {
    private JButton saveLoadButton;
    private JButton viewWorkoutHistoryButton;
    private JButton addWorkoutSessionButton;
    private JButton viewStatisticsButton;
    private JButton clickMeButton;
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
        clickMeButtonActionListener();
        windowCloserListener();
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
    // EFFECTS: action listener method for click me button; changes the image
    private void clickMeButtonActionListener() {
        clickMeButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability to change the image
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int min = 1;
                int max = 4;
                int index = rand.nextInt((max - min) + 1) + min;


                image.setIcon(new ImageIcon("data/Images/icon" + index + ".jpg"));
            }
        });
    }

    // EFFECTS: listener that prints the all the log events to the console at end of the application
    private void windowCloserListener() {
        addWindowListener(new WindowAdapter() {
            // EFFECTS: prints the all the log events to the console at end of the application
            @Override
            public void windowClosing(WindowEvent e) {
                EventLog theLog = EventLog.getInstance();
                for (Event event : theLog) {
                    System.out.println(event.getDescription() + " (" + event.getDate() + ")");
                }
                e.getWindow().dispose();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: creates a new icon
    private void createUIComponents() {
        image = new JLabel(new ImageIcon("data/Images/icon1.jpg"));
    }
}
