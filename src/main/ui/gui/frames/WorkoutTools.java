package ui.gui.frames;

import model.WorkoutHistory;
import model.WorkoutSession;
import ui.gui.popups.PopupNotification;

import javax.swing.*;

public abstract class WorkoutTools extends JFrame {
    protected static WorkoutHistory workoutHistory = new WorkoutHistory();
    protected static WorkoutSession workoutSession;

    // EFFECTS: safely gets user input, throws a popup error to user if input is different from type Double,
    //          returns the answer if success, otherwise returns -1.0
    protected double safelyGetDoubleInput(String input, String message) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            new PopupNotification().setMessage("Error: Please input an appropriate " + message + "!");
            return -1;
        }
    }

    // MODIFIES: inputStorage
    // EFFECTS: safely gets user input, throws a popup error to user if input is different from type int,
    //          returns the answer if success, otherwise returns -1
    protected int safelyGetIntInput(String input, String message) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            new PopupNotification().setMessage("Error: Please input an appropriate " + message + "!");
            return -1;
        }
    }
}
