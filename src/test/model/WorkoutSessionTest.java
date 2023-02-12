package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// a class that tests the implementations of the workout session class
class WorkoutSessionTest {
    private WorkoutSession testWorkoutSession;

    @BeforeEach
    void runBefore() {
        testWorkoutSession = new WorkoutSession(25, "2023-01-31", 3);
    }

    @Test
    void testConstructor() {
        assertEquals(new ArrayList<Exercise>(), testWorkoutSession.getExerciseList());
        assertEquals(25, testWorkoutSession.getTime());
        assertEquals("2023-01-31", testWorkoutSession.getDate());
        assertEquals(2023, testWorkoutSession.getYear());
        assertEquals(01, testWorkoutSession.getMonth());
        assertEquals(31, testWorkoutSession.getDay());
        assertEquals(3, testWorkoutSession.getHappinessScore());
    }

    @Test
    void testAddExercise() {
        // additional setup
        ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();
        Exercise exercise1 = new Exercise("Bench Press", 135, 10, 4);
        Exercise exercise2 = new Exercise("Dumbbell Curls", 35, 12, 4);

        assertEquals(exerciseList, testWorkoutSession.getExerciseList());

        testWorkoutSession.addExercise(exercise1);
        exerciseList.add(exercise1);
        assertEquals(exerciseList, testWorkoutSession.getExerciseList());

        testWorkoutSession.addExercise(exercise2);
        exerciseList.add(exercise2);
        assertEquals(exerciseList, testWorkoutSession.getExerciseList());
    }

    @Test
    void testRemoveExercise() {
        // additional setup
        ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();
        Exercise exercise1 = new Exercise("Bench Press", 135, 10, 4);
        Exercise exercise2 = new Exercise("Dumbbell Curls", 35, 12, 4);
        exerciseList.add(exercise1);
        exerciseList.add(exercise2);
        testWorkoutSession.addExercise(exercise1);
        testWorkoutSession.addExercise(exercise2);

        testWorkoutSession.removeExercise(exercise1);
        exerciseList.remove(exercise1);
        assertEquals(exerciseList, testWorkoutSession.getExerciseList());

        testWorkoutSession.removeExercise(exercise2);
        exerciseList.remove(exercise2);
        assertEquals(exerciseList, testWorkoutSession.getExerciseList());
    }

    @Test
    void testSetHappinessScore() {
        assertEquals(3, testWorkoutSession.getHappinessScore());

        testWorkoutSession.setHappinessScore(5);
        assertEquals(5, testWorkoutSession.getHappinessScore());

        testWorkoutSession.setHappinessScore(1);
        assertEquals(1, testWorkoutSession.getHappinessScore());
    }
}
