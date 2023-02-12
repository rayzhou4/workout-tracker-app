package ui;

import model.Exercise;
import model.WorkoutHistory;
import model.WorkoutSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    WorkoutHistory workoutHistory = new WorkoutHistory(); // the workout history that stores everything

    public static void main(String[] args) {
        mainMenu();


    }

    private static void mainMenu() {
        // initializing main variables
        int intUserInput;
        String stringUserInput;
        Scanner sc = new Scanner(System.in); // initializing scanner object

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
                    addWorkoutSession();
                    flag = false;
                    break;
                case 2:
                    viewWorkoutHistory(); // TODO
                    flag = false;
                    break;
                case 3:
                    viewStatistics(); // TODO
                    flag = false;
                    break;
                case 4:
                    viewHelp(); // TODO
                    flag = false;
                    break;
                default: // restarts the code block if user inputs a number not within the range
                    System.out.println("Please input within the appropriate range!");
                    flag = true;
            }
        } while (flag);
    }

    private static void printWorkoutSession(WorkoutSession workoutSession) {
        ArrayList<Exercise> workoutSessionList = workoutSession.getExerciseList();

        System.out.print("Your workout session so far: ");

        int counter = 1;
        for (Exercise exercise : workoutSessionList) {
            if (counter == workoutSessionList.size()) {
                System.out.println(exercise.getExercise() + " (" + exercise.getWeight() + "lbs, "
                        + exercise.getReps() + "reps X " + exercise.getSets() + "sets)");
            } else {
                System.out.print(exercise.getExercise() + " (" + exercise.getWeight() + "lbs, "
                        + exercise.getReps() + "reps X " + exercise.getSets() + "sets)" + ", ");
            }
            counter++;
        }
    }

    // add a workout session
    private static void addWorkoutSession() {
        Scanner sc = new Scanner(System.in); // initializing scanner object

        System.out.print("Time you exercised (in mins): ");
        int time = sc.nextInt();
        WorkoutSession workoutSession = new WorkoutSession(time); // initialize the workout session

        System.out.println("To add a workout session, first add exercises. So please input your first exercise.");
        workoutSession.addExercise(addAnExercise());

        printWorkoutSession(workoutSession);

        while (true) {
            System.out.println("(1) Add another exercise\n(2) Remove an exercise\n(3) Done");
            int intUserInput = sc.nextInt();

            if (intUserInput == 1) {
                workoutSession.addExercise(addAnExercise());
            } else if (intUserInput == 2) {
                workoutSession.removeExercise(removedExercise(workoutSession));
            } else {
                System.out.println("You have successfully added a workout session!");
                break;
            }
            printWorkoutSession(workoutSession);
        }
    }

    private static Exercise addAnExercise() {
        Scanner sc = new Scanner(System.in); // initializing scanner object

        System.out.print("Enter exercise name: ");
        String exerciseName = sc.nextLine();
        System.out.print("Enter exercise's weight in lbs (enter -1 if not applicable): ");
        double exerciseWeight = sc.nextDouble();
        System.out.print("Enter number of reps: ");
        int reps = sc.nextInt();
        System.out.print("Enter number of sets: ");
        int sets = sc.nextInt();

        return new Exercise(exerciseName, exerciseWeight, reps, sets);
    }

    private static Exercise removedExercise(WorkoutSession workoutSession) {
        Scanner sc = new Scanner(System.in); // initializing scanner object

        printWorkoutSession(workoutSession); // shows the user what the current list of exercises looks like
        System.out.print("Enter the position of the exercise you would like to remove"
                + " (1 for the first exercise in the list): ");
        int index = sc.nextInt() - 1;

        System.out.print("Are you sure you want to remove this the exercise ("
                + workoutSession.getExerciseList().get(index).getExercise() + ")? (y/n): ");
        String stringUserInput = sc.next();

        if (stringUserInput.equalsIgnoreCase("y")) {
            return workoutSession.getExerciseList().get(index);
        }

        return null; // returns null if user changes their mind
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

