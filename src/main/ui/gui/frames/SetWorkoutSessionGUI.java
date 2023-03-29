package ui.gui.frames;

import model.WorkoutSession;
import ui.gui.popups.PopupNotification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

// GUI class for the setting workout session page
public class SetWorkoutSessionGUI extends WorkoutTools {
    private JTextField textField1;
    private JTextField textField2;
    private JButton doneButton;
    private JPanel mainPanel;
    private JTextField textField3;

    // MODIFIES: this
    // EFFECTS: constructor; sets the GUI for the setting the workout session page
    public SetWorkoutSessionGUI() {
        setFrame();

        doneButtonActionListener();
    }

    // MODIFIES: this
    // EFFECTS: sets the frame for the GUI
    private void setFrame() {
        setContentPane(mainPanel);
        setTitle("Workout Tracker");
        setSize(400,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // EFFECTS: adapts the original safelyGetIntInput() for the happiness score
    protected int safelyGetIntInputHappinessScore(String input, String message) {
        int happinessScore = super.safelyGetIntInput(input, message);
        if ((happinessScore < 1 || happinessScore > 5) && happinessScore != -1) {
            new PopupNotification().setMessage("Error: Please input an appropriate happiness score!");
            return -1;
        } else {
            return happinessScore;
        }

    }

    // EFFECTS: returns a date to add to the workout session
    private String addDate() {
        String date = textField2.getText();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return date;
        } catch (Exception e) {
            return null; // returns null if the date was incorrect
        }
    }

    // MODIFIES: this
    // EFFECTS: action listener method for the done button; disposes the frame and stores the user input values
    private void doneButtonActionListener() {
        doneButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability to dispose the frame and store the user input values
            @Override
            public void actionPerformed(ActionEvent evt) {
                int time = safelyGetIntInput(textField1.getText(), "time");;
                int happinessScore = safelyGetIntInputHappinessScore(textField3.getText(), "happiness score");
                String date = addDate();

                if (date == null) {
                    new PopupNotification().setMessage("Error: Please input an appropriate date!");
                } else if (time != -1 && happinessScore != -1) {
                    workoutSession = new WorkoutSession(time, date, happinessScore);
                    new WorkoutSessionGUI();
                    dispose();
                }
            }
        });
    }
}


