package ui.gui.frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUI class for the statistics page
public class StatisticsGUI extends WorkoutTools {
    private JLabel totalWorkouts;
    private JLabel totalYearWorkouts;
    private JLabel totalMonthWorkouts;
    private JLabel averageTime;
    private JPanel mainPanel;
    private JButton doneButton;

    // MODIFIES: this
    // EFFECTS: constructor; sets the GUI for the statistics page
    public StatisticsGUI() {
        setFrame();

        doneButtonActionListener();
    }

    // MODIFIES: this
    // EFFECTS: sets the frame for the GUI
    private void setFrame() {
        setContentPane(mainPanel);
        setTitle("Workout Tracker");
        setSize(500,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        totalWorkouts.setText("Total Workouts: " + workoutHistory.getWorkoutHistory().size());
        totalYearWorkouts.setText("Total Workouts this year: " + workoutHistory.getTotalYear());
        totalMonthWorkouts.setText("Total Workouts this month: " + workoutHistory.getTotalMonth());
        try {
            averageTime.setText("Average Time per Workout: " + workoutHistory.getAverageTime() + " mins");
        } catch (ArithmeticException e) {
            // do nothing; caught exception
        }

    }

    // MODIFIES: this
    // EFFECTS: action listener method for the done button; disposes the frame
    private void doneButtonActionListener() {
        doneButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability to dispose the frame
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
