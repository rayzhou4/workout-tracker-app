package persistence;

import model.WorkoutSession;
import model.WorkoutHistory;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

// a class that tests the implementations of the json reader class
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/testFileNotExist.json");
        try {
            WorkoutHistory workoutHistory = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkoutHistory() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkoutHistory.json");
        try {
            WorkoutHistory workoutHistory = reader.read();
            List<WorkoutSession> workoutSessionList = workoutHistory.getWorkoutHistory();
            assertEquals(0, workoutSessionList.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderRegularWorkoutHistory() {
        JsonReader reader = new JsonReader("./data/testReaderRegularWorkoutHistory.json");
        try {
            WorkoutHistory workoutHistory = reader.read();
            List<WorkoutSession> workoutSessionList = workoutHistory.getWorkoutHistory();
            assertEquals(2, workoutSessionList.size());
            checkSession(0, 35, "2022-01-31", 5, workoutSessionList.get(0));
            checkSession(1, 65, "2023-04-04", 4, workoutSessionList.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
