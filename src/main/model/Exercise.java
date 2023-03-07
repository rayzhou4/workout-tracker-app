package model;

import org.json.JSONObject;
import persistence.Writable;

// an exercise class that contains information relating to an exercise
public class Exercise implements Writable {
    private String exercise;    // tracks the type of exercise
    private double weight;      // if applicable, the weight of how heavy the exercise was (ex. dumbbells) in lbs
    private int reps;           // the number of reps for each set of each exercise
    private int sets;           // the number of sets for each exercise

    // REQUIRES: exerciseName has a non-zero length
    // EFFECTS: exercise done is set to exerciseName; if this.weight >= 0, then
    //          weight is set to this.weight, otherwise this.weight is set to -1
    //          (meaning that the exercise doesn't involve any weights such as
    //          dumbbells, barbells, etc.), this.reps is set to reps, this.sets is
    //          set to sets
    public Exercise(String exerciseName, double weight, int reps, int sets) {
        this.exercise = exerciseName;
        if (weight >= 0) {
            this.weight = weight;
        } else {
            this.weight = -1;
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("exercise", this.exercise);
        json.put("weight", this.weight);
        json.put("reps", this.reps);
        json.put("sets", this.sets);
        return json;
    }
}