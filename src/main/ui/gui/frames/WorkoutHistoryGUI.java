package ui.gui.frames;

import model.WorkoutSession;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// GUI class for the workout history viewing page
public class WorkoutHistoryGUI extends WorkoutTools {
    private JPanel mainPanel;
    private JTable table;
    private JButton doneButton;
    private JComboBox comboBox;
    private DefaultComboBoxModel<String> comboBoxModel;
    private JButton openButton;
    private DefaultTableModel tableModel;

    // MODIFIES: this
    // EFFECTS: constructor; sets the GUI for the workout history viewing page
    public WorkoutHistoryGUI() {
        setFrame();

        openButtonActionListener();
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
        setComboBox();
    }

    // MODIFIES: this
    // EFFECTS: sets the table for the frame in the GUI
    private void setTable() {
        tableModel = new DefaultTableModel(
                null,
                new String[]{"no.", "Date (yyyy-mm-dd)", "Time (mins)", "Happiness Score"}
        );

        table.setEnabled(false);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setModel(tableModel);

        int counter = 1;
        ArrayList<WorkoutSession> workoutHistoryList = workoutHistory.getWorkoutHistory();

        for (WorkoutSession workoutSession : workoutHistoryList) {
            Object[] newRow = {
                    counter,
                    workoutSession.getDate(),
                    workoutSession.getTime(),
                    workoutSession.getHappinessScore()
            };
            tableModel.addRow(newRow);
            counter++;
        }
    }

    // MODIFIES: this
    // EFFECTS: sets the combo box for the frame in the GUI
    private void setComboBox() {
        comboBoxModel = new DefaultComboBoxModel<>();

        comboBox.setModel(comboBoxModel);

        int counter = 1;
        ArrayList<WorkoutSession> workoutHistoryList = workoutHistory.getWorkoutHistory();

        for (WorkoutSession workoutSession : workoutHistoryList) {
            String newSelection = counter + ") " + workoutSession.getDate()
                    + " (" + workoutSession.getTime() + " mins)";
            comboBoxModel.addElement(newSelection);
            counter++;
        }
    }

    // MODIFIES: this
    // EFFECTS: action listener method for the open button; opens the selected workout session
    private void openButtonActionListener() {
        openButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability to open the selected workout session
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBoxModel.getSelectedItem();

                int index = 0;
                for (int i = 0; i < comboBoxModel.getSize(); i++) {
                    if (comboBoxModel.getElementAt(i).equals(selected)) {
                        index = i;
                    }
                }

                WorkoutSession workoutSession = workoutHistory.getWorkoutHistory().get(index);

                new DetailedSessionViewGUI().addData(workoutSession);
            }
        });
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
