package ui.gui.frames;

import model.Exercise;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public WorkoutSessionGUI() {
        setFrame();

        addButtonActionListener();
        removeButtonActionListener();
        doneButtonActionListener();
    }

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

    private void setComboBox() {
        comboBoxModel = new DefaultComboBoxModel<>();

        comboBox.setModel(comboBoxModel);
    }

    private void addButtonActionListener() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = exerciseName.getText();
                double weight = Double.parseDouble(WorkoutSessionGUI.this.weight.getText());
                int sets = Integer.parseInt(WorkoutSessionGUI.this.sets.getText());
                int reps = Integer.parseInt(WorkoutSessionGUI.this.reps.getText());

                Exercise exercise = new Exercise(name, weight, sets, reps);

                workoutSession.addExercise(exercise);

                Object[] newRow = {name, weight, sets, reps};
                tableModel.addRow(newRow);

                String newSelection = name + " (" + weight + " lbs: " + reps + " X " + sets + ")";
                comboBoxModel.addElement(newSelection);
            }
        });
    }

    private void removeButtonActionListener() {
        removeButton.addActionListener(new ActionListener() {
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

    private void doneButtonActionListener() {
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workoutHistory.addWorkoutSession(workoutSession);
                dispose();
            }
        });
    }
}
