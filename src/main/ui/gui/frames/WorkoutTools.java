package ui.gui.frames;

import model.WorkoutHistory;
import model.WorkoutSession;

import javax.swing.*;

public abstract class WorkoutTools extends JFrame {
    protected static WorkoutHistory workoutHistory = new WorkoutHistory();
    protected static WorkoutSession workoutSession;
}
