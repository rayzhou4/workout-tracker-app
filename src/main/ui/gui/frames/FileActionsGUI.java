package ui.gui.frames;

import persistence.JsonReader;
import persistence.JsonWriter;
import ui.gui.popups.PopupNotification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileActionsGUI extends WorkoutTools {

    private static final String JSON_STORAGE = "./data/workouthistory.json";
    private JButton saveButton;
    private JButton loadButton;
    private JPanel mainPanel;
    private JButton doneButton;
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORAGE);
    private JsonReader jsonReader = new JsonReader(JSON_STORAGE);

    public FileActionsGUI() {
        setFrame();

        saveButtonActionListener();
        loadButtonActionListener();
        doneButtonActionListener();
    }

    private void setFrame() {
        setContentPane(mainPanel);
        setTitle("Workout Tracker");
        setSize(500,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void saveButtonActionListener() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(workoutHistory);
                    jsonWriter.close();
                    new PopupNotification().setMessage("Saved entire workout history to " + JSON_STORAGE);
                } catch (FileNotFoundException err) {
                    new PopupNotification().setMessage("Unable to write file to: " + JSON_STORAGE);
                }
            }
        });
    }

    private void loadButtonActionListener() {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    workoutHistory = jsonReader.read();
                    new PopupNotification().setMessage("Loaded previously saved workout history from " + JSON_STORAGE);
                } catch (IOException err) {
                    new PopupNotification().setMessage("Unable to read file from: \" + JSON_STORAGE");
                }
            }
        });
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
