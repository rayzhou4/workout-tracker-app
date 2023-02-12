package model;

public class Exercise {
    private String exercise;    // tracks the type of exercise
    private double weight;      // if applicable, the weight of how heavy the exercise was (ex. dumbbells) in lbs
    private int reps;           // the number of reps for each set of each exercise
    private int sets;           // the number of sets for each exercise

    // REQUIRES: exerciseName has a non-zero length
    // EFFECTS: exercise done is set to exerciseName; if this.weight >= 0, then
    //          weight is set to this.weight, otherwise this.weight is set to 0
    //          (meaning that the exercise doesn't involve any weights such as
    //          dumbbells, barbells, etc.), this.reps is set to reps, this.sets is
    //          set to sets
    public Exercise(String exerciseName, double weight, int reps, int sets) {
        this.exercise = exerciseName;
        if (this.weight >= 0) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
        this.reps = reps;
        this.sets = sets;
    }

    public String getExercise() {
        return this.exercise;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getReps() {
        return this.reps;
    }

    public int getSets() {
        return this.sets;
    }
}