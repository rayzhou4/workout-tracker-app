package ui.gui.frames;

import model.Exercise;
import model.WorkoutSession;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DetailedSessionViewGUI extends WorkoutTools {
    private JTable table;
    private JPanel mainPanel;
    private JButton doneButton;
    private DefaultTableModel tableModel;

    public DetailedSessionViewGUI() {
        setFrame();

        doneButtonActionListener();
    }

    private void setFrame() {
        setContentPane(mainPanel);
        setTitle("Workout Tracker");
        setSize(500,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        setTable();
    }

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

    private void doneButtonActionListener() {
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
