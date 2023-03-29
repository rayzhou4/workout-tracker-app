package ui.gui.frames;

import model.Exercise;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUI class for the workout session page
public class WorkoutSessionGUI extends WorkoutTools {
    private JButton addButton;
    private JTextField exerciseName;
    private JTextField weight;
    private JTextField sets;
    private JTable table;
    private DefaultTableModel tableModel;
    private DefaultComboBoxModel<String> comboBoxModel;
    private JTextField reps;
    private JButton doneButton;
    private JPanel mainPanel;
    private JButton removeButton;
    private JLabel timeLabel;
    private JLabel dateLabel;
    private JTabbedPane tabbedPane1;
    private JComboBox comboBox;

    // MODIFIES: this
    // EFFECTS: constructor; sets the GUI for the workout session page
    public WorkoutSessionGUI() {
        setFrame();

        addButtonActionListener();
        removeButtonActionListener();
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

        timeLabel.setText("Time: " + workoutSession.getTime() + " mins");
        dateLabel.setText("Date: " + workoutSession.getDate());

        setTable();
        setComboBox();
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

    // MODIFIES: this
    // EFFECTS: sets the combo box for the frame in the GUI
    private void setComboBox() {
        comboBoxModel = new DefaultComboBoxModel<>();

        comboBox.setModel(comboBoxModel);
    }

    // MODIFIES: this
    // EFFECTS: action listener method for the add button; adds the given exercise inputs to the workout session
    private void addButtonActionListener() {
        addButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability to add the given user inputs as an exercise to the workout session
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = exerciseName.getText();
                double weight = safelyGetDoubleInput(WorkoutSessionGUI.this.weight.getText(), "weight");
                int sets = safelyGetIntInput(WorkoutSessionGUI.this.sets.getText(), "value for sets");
                int reps = safelyGetIntInput(WorkoutSessionGUI.this.reps.getText(), "value for reps");

                if (weight != -1 && sets != -1 && reps != -1) {
                    Exercise exercise = new Exercise(name, weight, sets, reps);

                    workoutSession.addExercise(exercise);

                    Object[] newRow = {name, weight, sets, reps};
                    tableModel.addRow(newRow);

                    String newSelection = name + " (" + weight + " lbs: " + reps + " X " + sets + ")";
                    comboBoxModel.addElement(newSelection);
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: action listener method for the remove button; removes the selected exercise from the workout session
    private void removeButtonActionListener() {
        removeButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability to remove the selected exercise from the workout session
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBoxModel.getSelectedItem();

                int index = 0;
                for (int i = 0; i < comboBoxModel.getSize(); i++) {
                    if (comboBoxModel.getElementAt(i).equals(selected)) {
                        index = i;
                    }
                }

                Exercise exercise = workoutSession.getExerciseList().get(index);
                workoutSession.removeExercise(exercise);
                comboBoxModel.removeElement(selected);

                tableModel.removeRow(index);
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
                workoutHistory.addWorkoutSession(workoutSession);
                dispose();
            }
        });
    }
}
