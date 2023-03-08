package persistence;

import model.Exercise;
import model.WorkoutSession;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkSession(int index, int time, String date, int happinessScore, WorkoutSession workoutSession) {
        assertEquals(time, workoutSession.getTime());
        assertEquals(date, workoutSession.getDate());
        assertEquals(happinessScore, workoutSession.getHappinessScore());

        List<Exercise> exerciseList = workoutSession.getExerciseList();
        if (index == 0) {
            assertEquals(2, exerciseList.size());
            checkExercise("Sprinting", -1, -1, -1, exerciseList.get(0));
            checkExercise("Curls", 20, 15, 4, exerciseList.get(1));
        } else if (index == 1) {
            assertEquals(3, exerciseList.size());
            checkExercise("Bench Press", 135, 10, 4, exerciseList.get(0));
            checkExercise("Leg Press", 325, 10, 5, exerciseList.get(1));
            checkExercise("Shoulder Press", 60, 12, 4, exerciseList.get(2));
        }
    }

    protected void checkExercise(String exerciseName, double weight, int reps, int sets, Exercise exercise) {
        assertEquals(exerciseName, exercise.getExercise());
        assertEquals(weight, exercise.getWeight());
        assertEquals(reps, exercise.getReps());
        assertEquals(sets, exercise.getSets());
    }
}
