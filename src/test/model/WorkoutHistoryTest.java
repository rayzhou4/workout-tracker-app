package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

// a class that tests the implementations of the workout history class
class WorkoutHistoryTest {
    private WorkoutHistory testWorkoutHistory;
    private static final int CURRENT_YEAR = 2023;
    private static final int CURRENT_MONTH = Calendar.MONTH + 1;

    @BeforeEach
    void runBefore() {
        testWorkoutHistory = new WorkoutHistory();
    }

    @Test
    void testConstructor() {
        assertEquals(new ArrayList<WorkoutSession>(), testWorkoutHistory.getWorkoutHistory());
    }

    @Test
    void testAddWorkoutSession() {
        // additional setup
        ArrayList<WorkoutSession> workoutSessionsList = new ArrayList<WorkoutSession>();
        WorkoutSession workoutSession1 = new WorkoutSession(135, "2023-01-31", 3);
        WorkoutSession workoutSession2 = new WorkoutSession(35, "2020-12-31", 5);

        assertEquals(workoutSessionsList, testWorkoutHistory.getWorkoutHistory());

        testWorkoutHistory.addWorkoutSession(workoutSession1);
        workoutSessionsList.add(workoutSession1);
        assertEquals(workoutSessionsList, testWorkoutHistory.getWorkoutHistory());

        testWorkoutHistory.addWorkoutSession(workoutSession2);
        workoutSessionsList.add(workoutSession2);
        assertEquals(workoutSessionsList, testWorkoutHistory.getWorkoutHistory());
    }

    @Test
    void testRemoveWorkoutSession() {
        // additional setup
        ArrayList<WorkoutSession> workoutSessionsList = new ArrayList<WorkoutSession>();
        WorkoutSession workoutSession1 = new WorkoutSession(135, "2023-01-31", 3);
        WorkoutSession workoutSession2 = new WorkoutSession(35, "2020-12-31", 5);
        workoutSessionsList.add(workoutSession1);
        workoutSessionsList.add(workoutSession2);
        testWorkoutHistory.addWorkoutSession(workoutSession1);
        testWorkoutHistory.addWorkoutSession(workoutSession2);

        testWorkoutHistory.removeWorkoutSession(workoutSession1);
        workoutSessionsList.remove(workoutSession1);
        assertEquals(workoutSessionsList, testWorkoutHistory.getWorkoutHistory());

        testWorkoutHistory.removeWorkoutSession(workoutSession2);
        workoutSessionsList.remove(workoutSession2);
        assertEquals(workoutSessionsList, testWorkoutHistory.getWorkoutHistory());
    }

    @Test
    void testGetTotalYear() {
        assertEquals(0, testWorkoutHistory.getTotalYear());

        // additional setup
        WorkoutSession workoutSession1 = new WorkoutSession(135, "2023-01-31", 3);
        WorkoutSession workoutSession2 = new WorkoutSession(35, "2020-12-31", 5);
        testWorkoutHistory.addWorkoutSession(workoutSession1);
        testWorkoutHistory.addWorkoutSession(workoutSession2);

        if (CURRENT_YEAR == 2023) {
            assertEquals(1, testWorkoutHistory.getTotalYear());
        }
    }

    @Test
    void testGetTotalMonth() {
        assertEquals(0, testWorkoutHistory.getTotalMonth());

        // additional setup
        WorkoutSession workoutSession1 = new WorkoutSession(135,
                Integer.toString(CURRENT_YEAR) + "-02-31",
                3);
        WorkoutSession workoutSession2 = new WorkoutSession(35,
                Integer.toString(CURRENT_YEAR-1) + "-" + Integer.toString(CURRENT_MONTH) + "-20",
                5);
        WorkoutSession workoutSession3 = new WorkoutSession(20, "2020-02-20", 5);
        testWorkoutHistory.addWorkoutSession(workoutSession1);
        testWorkoutHistory.addWorkoutSession(workoutSession2);
        testWorkoutHistory.addWorkoutSession(workoutSession3);

        assertEquals(0, testWorkoutHistory.getTotalMonth());

        WorkoutSession workoutSession4 = new WorkoutSession(35,
                "2023-" + Integer.toString(CURRENT_MONTH) + "-21",
                5);
        testWorkoutHistory.addWorkoutSession(workoutSession4);

        if (CURRENT_YEAR == 2023) {
            assertEquals(1, testWorkoutHistory.getTotalMonth());
        }
    }

    @Test
    void testGetAverageTime() {
        // additional setup
        WorkoutSession workoutSession1 = new WorkoutSession(135, "2023-01-31", 3);
        WorkoutSession workoutSession2 = new WorkoutSession(35, "2020-02-20", 5);
        testWorkoutHistory.addWorkoutSession(workoutSession1);
        testWorkoutHistory.addWorkoutSession(workoutSession2);

        assertEquals((135+35)/2, testWorkoutHistory.getAverageTime());
    }
}
