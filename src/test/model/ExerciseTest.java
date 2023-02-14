package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// a class that tests the implementations of the exercise class
class ExerciseTest {
    private Exercise testExercise1;
    private Exercise testExercise2;

    @BeforeEach
    void runBefore() {
        testExercise1 = new Exercise("Bench Press", 135, 10, 4);
        testExercise2 = new Exercise("Wind Sprints", -35, 15, 5);
    }

    @Test
    void testConstructor() {
        assertEquals("Bench Press", testExercise1.getExercise());
        assertEquals(135, testExercise1.getWeight());
        assertEquals(10, testExercise1.getReps());
        assertEquals(4, testExercise1.getSets());

        assertEquals("Wind Sprints", testExercise2.getExercise());
        assertEquals(-1, testExercise2.getWeight());
        assertEquals(15, testExercise2.getReps());
        assertEquals(5, testExercise2.getSets());
    }
}