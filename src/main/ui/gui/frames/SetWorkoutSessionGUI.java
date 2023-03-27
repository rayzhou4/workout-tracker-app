package ui.gui.frames;

import model.WorkoutSession;
import ui.gui.popups.PopupNotification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class SetWorkoutSessionGUI extends WorkoutTools {
    private JTextField textField1;
    private JTextField textField2;
    private JButton doneButton;
    private JPanel mainPanel;
    private JTextField textField3;

    public SetWorkoutSessionGUI() {
        setFrame();

        doneButtonActionListener();
    }

    private void setFrame() {
        setContentPane(mainPanel);
        setTitle("Workout Tracker");
        setSize(400,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void doneButtonActionListener() {
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int time = Integer.parseInt(textField1.getText());
                int happinessScore = Integer.parseInt(textField3.getText());
                String date = addDate();
                if (date == null) {
                    new PopupNotification().setMessage("Error: Please input an appropriate date!");
                } else {
                    workoutSession = new WorkoutSession(time, date, happinessScore);
                    new WorkoutSessionGUI();
                    dispose();
                }
            }
        });
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
}


