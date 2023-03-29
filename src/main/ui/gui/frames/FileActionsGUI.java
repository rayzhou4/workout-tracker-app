package ui.gui.frames;

import persistence.JsonReader;
import persistence.JsonWriter;
import ui.gui.popups.PopupNotification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// GUI class for the file actions page
public class FileActionsGUI extends WorkoutTools {
    private static final String JSON_STORAGE = "./data/workouthistory.json";
    private JButton saveButton;
    private JButton loadButton;
    private JPanel mainPanel;
    private JButton doneButton;
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORAGE);
    private JsonReader jsonReader = new JsonReader(JSON_STORAGE);

    // MODIFIES: this
    // EFFECTS: constructor; sets the GUI for the file actions page
    public FileActionsGUI() {
        setFrame();

        saveButtonActionListener();
        loadButtonActionListener();
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
    }

    // MODIFIES: this
    // EFFECTS: action listener method for the save button; saves/writes data to the json storage file
    private void saveButtonActionListener() {
        saveButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability save/write data to the json storage file
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

    // MODIFIES: this
    // EFFECTS: action listener method for the load button; loads/reads data from the json storage file
    private void loadButtonActionListener() {
        loadButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability to load/read data from the json storage file
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    workoutHistory = jsonReader.read();
                    new PopupNotification().setMessage("Loaded previously saved workout history from " + JSON_STORAGE);
                } catch (IOException err) {
                    new PopupNotification().setMessage("Unable to read file from: " + JSON_STORAGE);
                }
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
