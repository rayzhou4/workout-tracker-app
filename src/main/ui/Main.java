package ui;

import model.WorkoutHistory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initializing main variables
        WorkoutHistory workoutHistory = new WorkoutHistory();
        Scanner sc = new Scanner(System.in); // initializing scanner object

        // introducing application to user
        System.out.println("Main Menu:\n"
                + "(1) Add a workout session\n"
                + "(2) View your entire workout history\n"
                + "(3) View your statistics\n"
                + "(4) Help");


    }
}
