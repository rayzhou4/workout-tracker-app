package model;

import java.util.ArrayList;
import java.util.Calendar;

public class WorkoutHistory {
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
        return this.workoutSessionList;
    }


    // MODIFIES: this
    // EFFECTS: removes a workout session from the current list of workout sessions,
    // new list of workout sessions is returned
    public ArrayList<WorkoutSession> removeWorkout(WorkoutSession workoutSession) {
        this.workoutSessionList.remove(workoutSession);
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

    // EFFECTS:
    public int getAverageTime() {
        int sum = 0;
        for (WorkoutSession workoutSession : this.workoutSessionList) {
            sum += workoutSession.getTime();
        }
        return sum / workoutSessionList.size();
    }
}
