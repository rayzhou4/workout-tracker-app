package persistence;

import model.Exercise;
import model.WorkoutHistory;
import model.WorkoutSession;
import org.json.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// a json reader class that reads a json file
public class JsonReader {
    private String root;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String root) {
        this.root = root;
    }

    // EFFECTS: reads workoutHistory from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkoutHistory read() throws IOException {
        String jsonData = readFile(root);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkoutHistory(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workoutHistory from JSON object and returns it
    private WorkoutHistory parseWorkoutHistory(JSONObject jsonObject) {
        WorkoutHistory workoutHistory = new WorkoutHistory();
        addWorkoutSessions(workoutHistory, jsonObject);
        return workoutHistory;
    }

    // MODIFIES: workoutHistory
    // EFFECTS: parses workout sessions from JSON object and adds them to workoutHistory
    private void addWorkoutSessions(WorkoutHistory workoutHistory, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("workout sessions");
        for (Object json : jsonArray) {
            JSONObject nextWorkoutSession = (JSONObject) json;
            addWorkoutSession(workoutHistory, nextWorkoutSession);
        }
    }

    // MODIFIES: workoutHistory
    // EFFECTS: parses workout sessions from JSON object and adds it to workHistory
    private void addWorkoutSession(WorkoutHistory workoutHistory, JSONObject jsonObject) {
        int time = jsonObject.getInt("time");
        String date = jsonObject.getString("date");
        int happinessScore = jsonObject.getInt("happiness score");


        WorkoutSession workoutSession = new WorkoutSession(time, date, happinessScore);
        addExercises(workoutSession, jsonObject);
        workoutHistory.addWorkoutSession(workoutSession);
    }

    // MODIFIES: workoutSession
    // EFFECTS: parses exercises from JSON object and adds them to workoutSession
    private void addExercises(WorkoutSession workoutSession, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("exercises");
        for (Object json : jsonArray) {
            JSONObject nextExerciseList = (JSONObject) json;
            addExercise(workoutSession, nextExerciseList);
        }
    }

    // MODIFIES: workoutSession
    // EFFECTS: parses exercises from JSON object and adds it to workoutSession
    private void addExercise(WorkoutSession workoutSession, JSONObject jsonObject) {
        String exerciseName = jsonObject.getString("exercise");
        int weight = jsonObject.getInt("weight");
        int reps = jsonObject.getInt("reps");
        int sets = jsonObject.getInt("sets");

        Exercise exercise = new Exercise(exerciseName, weight, reps, sets);
        workoutSession.addExercise(exercise);
    }
}
