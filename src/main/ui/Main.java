package ui;

import model.WorkoutHistory;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initializing main variables
        WorkoutHistory workoutHistory = new WorkoutHistory();
        int intUserInput;
        String stringUserInput;
        Scanner sc = new Scanner(System.in); // initializing scanner object

        // switch case to decide what action to take
        boolean flag; // initialize a boolean to break out of do while loop
        do {
            // introducing application to user (the main menu)
            System.out.println("Main Menu:\n"
                    + "(1) Add a workout session\n"
                    + "(2) View your entire workout history\n"
                    + "(3) View your statistics\n"
                    + "(4) Help");

            intUserInput = sc.nextInt();
            switch (intUserInput) {
                case 1:
                    addWorkoutSession(); // TODO
                    flag = false;
                    break;
                case 2:
                    viewWorkoutHistory(); // TODO
                    flag = false;
                    break;
                    //
                case 3:
                    viewStatistics(); // TODO
                    flag = false;
                    break;
                    //
                case 4:
                    viewHelp(); // TODO
                    flag = false;
                    break;
                    //
                default: // restarts the code block if user inputs a number not within the range
                    System.out.println("Please input within the appropriate range!");
                    flag = true;
            }
        } while (flag);

    }
}
