package ui;

import model.Exercise;
import model.WorkoutHistory;
import model.WorkoutSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static WorkoutHistory workoutHistory = new WorkoutHistory(); // the workout history that stores everything

    public static void main(String[] args) {
        mainMenu();


    }

    private static void mainMenu() {
        // initializing main variables
        String stringUserInput;
        Scanner sc = new Scanner(System.in); // initializing scanner object

        boolean flag; // initialize a boolean to break out of do while loop
        do {
            // introducing application to user (the main menu)
            System.out.println("Main Menu:\n" + "(1) Add a workout session\n" + "(2) View your entire workout history\n"
                    + "(3) View your statistics\n" + "(4) Help\n" + "(5) Exit");

            int intUserInput = sc.nextInt();
            switch (intUserInput) {
                case 1:
                    addWorkoutSession();
                    flag = true;
                    break;
                case 2:
                    viewWorkoutHistory();
                    flag = true;
                    break;
                case 3:
                    viewStatistics(); // TODO
                    flag = true;
                    break;
                case 4:
                    viewHelp(); // TODO
                    flag = true;
                    break;
                case 5:
                    flag = false;
                    break;
                default: // restarts the code block if user inputs a number not within the range
                    System.out.println("Please input within the appropriate range!");
                    flag = true;
            }
        } while (flag);
    }

    // general helper
    private static void printWorkoutSession(WorkoutSession workoutSession) {
        ArrayList<Exercise> workoutSessionList = workoutSession.getExerciseList();

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
        // getting the length of time of the workout session
        System.out.print("Time you exercised (in mins): ");
        int time = sc.nextInt();
        // getting the date of the workout session
        String date = addDate();
        while (date == null) {
            System.out.println("Please input an appropriate date.");
            date = addDate();
        }
        WorkoutSession workoutSession = new WorkoutSession(time, date); // initialize the workout session

        System.out.println("To add a workout session, first add exercises. So please input your first exercise.");
        workoutSession.addExercise(addAnExercise());
        System.out.print("Your workout session so far: ");
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
            System.out.print("Your workout session so far: ");
            printWorkoutSession(workoutSession);
        }
        workoutHistory.addWorkoutSession(workoutSession);
    }

    // addWorkoutSession() helper: adds an exercise
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

    // addWorkoutSession() helper: removes an exercise
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

    // addWorkoutSession() helper: adds a date for the workout session
    public static String addDate() {
        Scanner sc = new Scanner(System.in); // initializing scanner object

        System.out.print("Date (yyyy-mm-dd): ");
        String date = sc.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return date;
        } catch (Exception e) {
            return null; // returns null if the date was incorrect
        }
    }



    // view entire workout history
    private static void viewWorkoutHistory() {
        Scanner sc = new Scanner(System.in);
        ArrayList<WorkoutSession> workoutHistoryList = workoutHistory.getWorkoutHistory();

        System.out.println("This is what your current workout history looks like (only first 10 workout): ");

        int counter = 1;
        for (WorkoutSession workoutSession : workoutHistoryList) {
            System.out.println(counter + ") " + workoutSession.getYear() + "-" + workoutSession.getMonth() + "-"
                    + workoutSession.getDay() + " (" + workoutSession.getTime() + "mins)");
            counter++;
        }

        System.out.print("Would you like to view any of these workout sessions? (y/n): ");
        String stringUserInput = sc.next();

        if (stringUserInput.equalsIgnoreCase("y")) {
            System.out.print("Which workout session would you like to view: ");
            int index = sc.nextInt() - 1;
            System.out.println("Selected Workout Session (detailed view):");
            printWorkoutSession(workoutHistoryList.get(index));
        }
    }

    // view the statistics of the user's workout history
    private static void viewStatistics() {
        System.out.println("Total Workouts: " + workoutHistory.getWorkoutHistory().size()
                + "\nTotal Workouts this year: " + workoutHistory.getTotalYear()
                + "\nTotal Workout this month: " + workoutHistory.getTotalMonth()
                + "\nAverage Time per Workout: " + workoutHistory.getAverageTime() + " mins");
    }

    // view the help menu
    private static void viewHelp() {

    }
}

