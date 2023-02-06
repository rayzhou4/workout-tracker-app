package model;

import java.util.ArrayList;
import java.util.Date;

public class WorkoutSession {
    private ArrayList<Exercise> exerciseList; // the list of exercises done during the workout session
    private int time;                         // how long the workout lasted (in minutes)
    Date date;                                // when the workout session was (in Date)

    /*
     * REQUIRES: exercises is not empty AND time > 0
     * EFFECTS: this.exercises is set to an empty arraylist; this.time is set to time
     *          this.date is set to date
     */
    public WorkoutSession(int time, Date date) {
        this.exerciseList = new ArrayList<Exercise>();
        this.time = time;
        this.date = date;
    }

    public ArrayList<Exercise> getExerciseList() {
        return this.exerciseList;
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
     *          new list of exercises is returned
     */
    public ArrayList<Exercise> addExercise(Exercise exercise) {
        this.exerciseList.add(exercise);
        return this.exerciseList;
    }

    /*
     * MODIFIES: this
     * EFFECTS: removes an exercise from the current list of exercises,
     *          new list of exercises is returned
     */
    public ArrayList<Exercise> removeExercise(Exercise exercise) {
        this.exerciseList.remove(exercise);
        return this.exerciseList;
    }
}
