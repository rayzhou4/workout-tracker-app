package ui;

import model.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

// Workout Tracker application
public class WorkoutApp {
    private WorkoutHistory workoutHistory = new WorkoutHistory(); // the workout history that stores everything
    private WorkoutSession workoutSession;
    private Scanner sc; //initializing scanner object

    // EFFECTS: runs the workout application
    public WorkoutApp() {
        startApp();
    }

    // EFFECTS: processes user input
    private void startApp() {
        sc = new Scanner(System.in); // initializing scanner object

        while (true) {
            // introducing application to user (the main menu)
            System.out.println("Main Menu:\n" + "(1) Add a workout session\n" + "(2) View your entire workout history\n"
                    + "(3) View your statistics\n" + "(4) Exit");

            int intUserInput = sc.nextInt();
            if (intUserInput == 1) {
                addWorkoutSession();
            } else if (intUserInput == 2) {
                viewWorkoutHistory();
            } else if (intUserInput == 3) {
                viewStatistics();
            } else if (intUserInput == 4) {
                break;
            } else {
                System.out.println("Please input within the appropriate range!");
            }
        }
    }

    // EFFECTS: prints a given workout session
    private void printWorkoutSession(WorkoutSession workoutSession) {
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

    // MODIFIES: this
    // EFFECTS: adds a workout session to the workout history
    private void addWorkoutSession() {
        sc = new Scanner(System.in); // initializing scanner object
        workoutSession = initializeWorkoutSession(); // initializing workout session object

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
        workoutSession.setHappinessScore(addScore());
        workoutHistory.addWorkoutSession(workoutSession);
    }

    // MODIFIES: this
    // EFFECTS: initializes a workout session
    private WorkoutSession initializeWorkoutSession() {
        sc = new Scanner(System.in); // initializing scanner object

        // getting the length of time of the workout session
        System.out.print("Time you exercised (in mins): ");
        int time = sc.nextInt();

        // getting the date of the workout session
        String date = addDate();
        while (date == null) {
            System.out.println("Please input an appropriate date.");
            date = addDate();
        }

        WorkoutSession workoutSession = new WorkoutSession(time, date, -1); // initialize workout session
        return workoutSession;
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to the current workout session
    private Exercise addAnExercise() {
        sc = new Scanner(System.in); // initializing scanner object

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

    // MODIFIES: this
    // EFFECTS: removes an exercise from the current workout session
    private Exercise removedExercise(WorkoutSession workoutSession) {
        sc = new Scanner(System.in); // initializing scanner object

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

    // EFFECTS: returns a date to add to the workout session
    private String addDate() {
        sc = new Scanner(System.in); // initializing scanner object

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

    // EFFECTS: returns the user's happiness score to the workout session
    private int addScore() {
        sc = new Scanner(System.in);

        System.out.print("Rate how you felt after this workout session (1 being the worst, 5 being the best): ");
        int userScore = sc.nextInt();
        while (userScore < 1 || userScore > 5) {
            System.out.print("Please input an appropriate score: ");
            userScore = sc.nextInt();
        }

        return userScore;
    }

    // EFFECTS: view the entire workout history (collection of workout sessions)
    private void viewWorkoutHistory() {
        sc = new Scanner(System.in);
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

    // EFFECTS: view the statistics of the user's workout history
    private void viewStatistics() {
        System.out.println("Total Workouts: " + workoutHistory.getWorkoutHistory().size()
                + "\nTotal Workouts this year: " + workoutHistory.getTotalYear()
                + "\nTotal Workout this month: " + workoutHistory.getTotalMonth()
                + "\nAverage Time per Workout: " + workoutHistory.getAverageTime() + " mins");
    }

}

