package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Calendar;

// a workout history class that contains information relating to the entire workout history of the user
public class WorkoutHistory implements Writable {
    private ArrayList<WorkoutSession> workoutSessionList;

    // MODIFIES: this
    // EFFECTS: constructs a holder for all the workout sessions, starting with none
    public WorkoutHistory() {
        this.workoutSessionList = new ArrayList<WorkoutSession>();
    }

    public ArrayList<WorkoutSession> getWorkoutHistory() {
        return this.workoutSessionList;
    }

    // MODIFIES: this
    // EFFECTS: adds a workout session to the current list/history of workout sessions,
    //          new list of workout sessions is returned
    public ArrayList<WorkoutSession> addWorkoutSession(WorkoutSession workoutSession) {
        this.workoutSessionList.add(workoutSession);
        EventLog.getInstance().logEvent(new Event("Workout Session added."));
        return this.workoutSessionList;
    }


    // MODIFIES: this
    // EFFECTS: removes a workout session from the current list of workout sessions,
    // new list of workout sessions is returned
    public ArrayList<WorkoutSession> removeWorkoutSession(WorkoutSession workoutSession) {
        this.workoutSessionList.remove(workoutSession);
        EventLog.getInstance().logEvent(new Event("Workout Session removed."));
        return this.workoutSessionList;
    }

    // EFFECTS: counts the total number of workouts done in the current year
    public int getTotalYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int total = 0;
        for (WorkoutSession workoutSession : this.workoutSessionList) {
            if (workoutSession.getYear() == year) {
                total++;
            }
        }
        return total;
    }

    // EFFECTS: counts the total number of workouts done in the current month
    public int getTotalMonth() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int total = 0;
        for (WorkoutSession workoutSession : this.workoutSessionList) {
            if (workoutSession.getMonth() == month && workoutSession.getYear() == year) {
                total++;
            }
        }
        return total;
    }

    // REQUIRES: there must be at least one workout session in the workoutSessionList
    // EFFECTS: gets the average time
    public int getAverageTime() {
        int sum = 0;
        for (WorkoutSession workoutSession : this.workoutSessionList) {
            sum += workoutSession.getTime();
        }
        return sum / workoutSessionList.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("workout sessions", workoutSessionsToJson());
        return json;
    }

    // EFFECTS: returns workout sessions in this workout history as a JSON array
    private JSONArray workoutSessionsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (WorkoutSession workoutSession : this.workoutSessionList) {
            jsonArray.put(workoutSession.toJson());
        }

        return jsonArray;
    }
}
