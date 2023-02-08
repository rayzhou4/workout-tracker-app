package ui;

import model.Exercise;
import model.WorkoutHistory;
import model.WorkoutSession;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    WorkoutHistory workoutHistory = new WorkoutHistory(); // the workout history that stores everything
    public static void main(String[] args) {
        // initializing main variables
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

    // add a workout session
    private static void addWorkoutSession() {
        WorkoutSession workoutSession = null; // initialize the workout session
        Scanner sc = new Scanner(System.in); // initializing scanner object

        System.out.println("To add a workout session, we must first add exercises."
                + "So please input your first exercise:");

        int intUserInput = 1; // initialize user input (initialized to 1 to start loop for the first time)
        while (true) {
            System.out.print("Enter exercise name: ");
            String exerciseName = sc.next();
            System.out.print("Enter exercise's weight (if applicable): ");
            double exerciseWeight = sc.nextDouble();
            
            workoutSession.addExercise(new Exercise(exerciseName, exerciseWeight));

            System.out.println("(1) Add another exercise\n(2) Remove an exercise\n(3) Done");
            intUserInput = sc.nextInt();
            // WRONG STUFF RIGHT NOW!!!!
            if (intUserInput == 3) {
                break;
            }

            // prints workout session so far
            System.out.println("Your Workout Session so far:");

        }

        System.out.println("You have successfully added a workout session!");
    }

    // view entire workout history
    private static void viewWorkoutHistory() {

    }

    // view the statistics of the user's workout history
    private static void viewStatistics() {

    }

    // view the help menu
    private static void viewHelp() {

    }
}
