package model;

import java.util.ArrayList;
import java.util.Date;

public class WorkoutSession {
    private ArrayList<Exercise> exercises;    // the list of exercises done during the workout session
    private int time;                         // how long the workout lasted (in minutes)
    Date date;                                // when the workout session was (in Date)

    /*
     * REQUIRES: exercises is not empty AND time > 0
     * EFFECTS: this.exercises is set to exercises; this.time is set to time
     *          this.date is set to date
     */
    public WorkoutSession(ArrayList<Exercise> exercises, int time, Date date) {
        this.exercises = exercises;
        this.time = time;
        this.date = date;
    }

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }

    public int getTime() {
        return this.time;
    }

    public Date getDate() {
        return this.date;
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds an exercise to the current list of exercises,
     *          list of exercises is returned
     */
    public ArrayList<Exercise> addExercise(Exercise exercise) {
        this.exercises.add(exercise);
        return this.exercises;
    }

    /*
     * MODIFIES: this
     * EFFECTS: removes an exercise to the current list of exercises,
     *          list of exercises is returned
     */
    public ArrayList<Exercise> removeExercise(Exercise exercise) {
        this.exercises.remove(exercise);
        return this.exercises;
    }
}
