package model;

import java.util.Date;

public class Exercise {
    private String exercise;    // tracks the type of exercise
    private double weight;      // if applicable, the weight of how heavy the exercise was (ex. dumbbells) in lbs

    /*
     * REQUIRES: exerciseName has a non-zero length
     * EFFECTS: exercise done is set to exerciseName; if this.weight >= 0, then
     *          weight is set to this.weight, otherwise this.weight is set to 0
     *          (meaning that the exercise doesn't involve any weights such as
     *          dumbbells, barbells, etc.)
     */
    public Exercise(String exerciseName, double weight) {
        this.exercise = exerciseName;
        if (this.weight >= 0) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
    }

    public String getExercise() {
        return this.exercise;
    }

    public double getWeight() {
        return this.weight;
    }


    /*
     * MODIFIES: this
     * EFFECTS: changes the weight of the exercise (if user inputted incorrectly),
     *          weight is returned
     */
    public double changeWeight(double newWeight) {
        this.weight = newWeight;
        return this.weight;
    }
}