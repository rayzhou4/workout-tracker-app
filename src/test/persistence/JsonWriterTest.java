package persistence;

import model.Exercise;
import model.WorkoutSession;
import model.WorkoutHistory;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// a class that tests the implementations of the json writer class
public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            WorkoutHistory workoutHistory = new WorkoutHistory();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkoutHistory() {
        try {
            WorkoutHistory workoutHistory = new WorkoutHistory();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkoutHistory.json");
            writer.open();
            writer.write(workoutHistory);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkoutHistory.json");
            workoutHistory = reader.read();
            List<WorkoutSession> workoutSessionList = workoutHistory.getWorkoutHistory();
            assertEquals(0, workoutSessionList.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterRegularWorkoutHistory() {
        try {
            WorkoutHistory workoutHistory = new WorkoutHistory();
            WorkoutSession workoutSession1 = new WorkoutSession(35, "2022-01-31", 5);
            workoutSession1.addExercise(new Exercise("Sprinting", -1, -1, -1));
            workoutSession1.addExercise(new Exercise("Curls", 20, 15, 4));
            workoutHistory.addWorkoutSession(workoutSession1);
            WorkoutSession workoutSession2 = new WorkoutSession(65, "2023-04-04", 4);
            workoutSession2.addExercise(new Exercise("Bench Press", 135, 10, 4));
            workoutSession2.addExercise(new Exercise("Leg Press", 325, 10, 5));
            workoutSession2.addExercise(new Exercise("Shoulder Press", 60, 12, 4));
            workoutHistory.addWorkoutSession(workoutSession2);
            JsonWriter writer = new JsonWriter("./data/testWriterRegularWorkoutHistory.json");
            writer.open();
            writer.write(workoutHistory);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterRegularWorkoutHistory.json");
            workoutHistory = reader.read();
            List<WorkoutSession> workoutSessionList = workoutHistory.getWorkoutHistory();
            assertEquals(2, workoutSessionList.size());
            checkSession(0, 35, "2022-01-31", 5, workoutSessionList.get(0));
            checkSession(1, 65, "2023-04-04", 4, workoutSessionList.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
