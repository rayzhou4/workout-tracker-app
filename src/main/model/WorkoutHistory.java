package model;

import java.util.ArrayList;

public class WorkoutHistory {

    private ArrayList<WorkoutSession> workoutSessionList;

    /*
     * MODIFIES: this
     * EFFECTS: constructs a holder for all the workout sessions, starting with none
     */
    public WorkoutHistory() {
        this.workoutSessionList = new ArrayList<WorkoutSession>();
    }

    public ArrayList<WorkoutSession> getWorkoutHistory() {
        return this.workoutSessionList;
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds a workout session to the current list/history of workout sessions,
     *          new list of workout sessions is returned
     */
    public ArrayList<WorkoutSession> addWorkoutSession(WorkoutSession workoutSession) {
        this.workoutSessionList.add(workoutSession);
        return this.workoutSessionList;
    }

    /*
     * MODIFIES: this
     * EFFECTS: removes a workout session from the current list of workout sessions,
     *          new list of workout sessions is returned
     */
    public ArrayList<WorkoutSession> removeWorkout(WorkoutSession workoutSession) {
        this.workoutSessionList.remove(workoutSession);
        return this.workoutSessionList;
    }
}
