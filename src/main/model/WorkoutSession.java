package model;

import java.util.ArrayList;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class WorkoutSession {
    private ArrayList<Exercise> exerciseList; // the list of exercises done during the workout session
    private int time;                         // how long the workout lasted (in minutes)
    private int year;                         // when the workout took place (year)
    private int month;                        // when the workout took place (month)
    private int day;                          // when the workout took place (day)

    /*
     * REQUIRES: time > 0
     * EFFECTS: this.exercises is set to an empty arraylist; this.time is set to time
     *          this.year is set to the given year, this.month is set to the given month,
     *          this.day is set to the given day
     */
    public WorkoutSession(int time, String date) {
        this.exerciseList = new ArrayList<Exercise>();
        this.time = time;
        this.year = parseInt(date.split("-")[0]);
        this.month = parseInt(date.split("-")[1]);
        this.day = parseInt(date.split("-")[2]);
    }

    /*
     * REQUIRES: exercises is not empty AND time > 0
     * EFFECTS: this.exercises is set to an empty arraylist; this.time is set to time
     *          this.date is set to date
     */
    public ArrayList<Exercise> getExerciseList() {
        return this.exerciseList;
    }

    public int getTime() {
        return this.time;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
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
