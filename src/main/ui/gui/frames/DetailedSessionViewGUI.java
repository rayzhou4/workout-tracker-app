package ui.gui.frames;

import model.Exercise;
import model.WorkoutSession;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// GUI class for the detailed session view page
public class DetailedSessionViewGUI extends WorkoutTools {
    private JTable table;
    private JPanel mainPanel;
    private JButton doneButton;
    private DefaultTableModel tableModel;

    // MODIFIES: this
    // EFFECTS: constructor; sets the GUI for the detailed session view page
    public DetailedSessionViewGUI() {
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

        setTable();
    }

    // MODIFIES: this
    // EFFECTS: sets the table for the frame in the GUI
    private void setTable() {
        tableModel = new DefaultTableModel(
                null,
                new String[]{"Exercise", "Weight (lbs)", "Reps", "Sets"}
        );

        table.setEnabled(false);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setModel(tableModel);
    }

    // REQUIRES: requires a non-empty Exercise List within the workoutSession object
    // MODIFIES: this
    // EFFECTS: gets the exercises in workoutSession's exercise list and adds it to the table in the GUI
    public void addData(WorkoutSession workoutSession) {
        ArrayList<Exercise> workoutSessionList = workoutSession.getExerciseList();
        for (Exercise exercise : workoutSessionList) {
            Object[] newRow = {
                    exercise.getExercise(),
                    exercise.getWeight(),
                    exercise.getSets(),
                    exercise.getReps()
            };
            tableModel.addRow(newRow);
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
