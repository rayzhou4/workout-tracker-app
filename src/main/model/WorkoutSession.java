package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

// a workout session class that includes a list of exercises with additional information relating to workout sessions
public class WorkoutSession implements Writable {
    private ArrayList<Exercise> exerciseList; // the list of exercises done during the workout session
    private int time;                         // how long the workout lasted (in minutes)
    private String date;                      // the date of the workout session (in string format)
    private int year;                         // when the workout took place (year)
    private int month;                        // when the workout took place (month)
    private int day;                          // when the workout took place (day)
    private int happinessScore;               // happiness score after the workout session

    // REQUIRES: time > 0 AND date is in correct format & is appropriate
    // EFFECTS: this.exercises is set to an empty arraylist; this.time is set to time
    //          this.year is set to the given year, this.month is set to the given month,
    //          this.day is set to the given day, this.happinessScore is set to the given
    //          happinessScore
    public WorkoutSession(int time, String date, int happinessScore) {
        this.exerciseList = new ArrayList<Exercise>();
        this.time = time;
        this.date = date;
        this.year = parseInt(date.split("-")[0]);
        this.month = parseInt(date.split("-")[1]);
        this.day = parseInt(date.split("-")[2]);
        this.happinessScore = happinessScore;
    }

    public ArrayList<Exercise> getExerciseList() {
        return this.exerciseList;
    }

    public int getTime() {
        return this.time;
    }

    public String getDate() {
        return this.date;
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

    public int getHappinessScore() {
        return happinessScore;
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to the current list of exercises,
    // new list of exercises is returned
    public ArrayList<Exercise> addExercise(Exercise exercise) {
        this.exerciseList.add(exercise);
        EventLog.getInstance().logEvent(new Event("Exercise added (details: " + exercise.getExercise()
                + " - " + exercise.getWeight() + "lbs - " + exercise.getReps() + " X " + exercise.getSets() + ")."));
        return this.exerciseList;
    }

    // REQUIRES: exercise exists inside this.exerciseList
    // MODIFIES: this
    // EFFECTS: removes an exercise from the current list of exercises,
    // new list of exercises is returned
    public ArrayList<Exercise> removeExercise(Exercise exercise) {
        this.exerciseList.remove(exercise);
        EventLog.getInstance().logEvent(new Event("Exercise removed (details: " + exercise.getExercise()
                + " - " + exercise.getWeight() + "lbs - " + exercise.getReps() + " X " + exercise.getSets() + ")."));
        return this.exerciseList;
    }

    // REQUIRES: 1 <= newScore <= 5
    // MODIFIES: this
    // EFFECTS: changes the happiness score for the workout session
    public int setHappinessScore(int newScore) {
        return this.happinessScore = newScore;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("time", this.time);
        json.put("date", this.date);
        json.put("happiness score", this.happinessScore);
        json.put("exercises", exercisesToJson());
        return json;
    }

    // EFFECTS: returns exercises in this workout session as a JSON array
    public JSONArray exercisesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Exercise exercise : this.exerciseList) {
            jsonArray.put(exercise.toJson());
        }

        return jsonArray;
    }
}
