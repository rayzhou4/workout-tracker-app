package ui.gui;

import model.WorkoutHistory;
import model.WorkoutSession;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

// Main Graphical User Interface class
class WorkoutAppGUI {

    private JFrame frame;
    private BookShelfGUI bookShelfPanel = new BookShelfGUI();
    private ReadingListGUI readingListPanel = new ReadingListGUI();
    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    protected static CardLayout cardLayout = new CardLayout();


    private int count = 0;
    private JFrame frame;
    private JLabel label;
    private JInternalFrame mainMenu;
    private JPanel panel;
    private static final String JSON_STORAGE = "./data/workouthistory.json";
    private WorkoutHistory workoutHistory = new WorkoutHistory(); // the workout history that stores everything
    private WorkoutSession workoutSession;
    private Scanner sc; //initializing scanner object
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORAGE);
    private JsonReader jsonReader = new JsonReader(JSON_STORAGE);

    public WorkoutAppGUI() {
        frame = new JFrame();

        JButton button = new JButton("button");
        button.addActionListener(this);

        label = new JLabel("Number of  clicks: 0");

        mainMenu = new JInternalFrame("Main Menu", false, false, false, false);
        mainMenu.setLayout(new BorderLayout());

        addButtonPanel();

        mainMenu.pack();
        mainMenu.setVisible(true);

        frame.setSize(900, 700);
        frame.add(mainMenu, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Workout Tracker");
        frame.pack();
        frame.setVisible(true);
    }

    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,2));
        buttonPanel.add(new JButton(new AddWorkoutSession()));
//        buttonPanel.add(new JButton(new RemoveWorkoutSession()));
//        buttonPanel.add(new JButton(new ViewHistory()));
//        buttonPanel.add(new JButton(new SaveFile()));
//        buttonPanel.add(new JButton(new LoadFile()));

        mainMenu.add(buttonPanel, BorderLayout.WEST);
    }

    // EFFECTS: creates the graphical user interface
    public static void main(String args[]){
        new Gui();
    }


    private class AddWorkoutSession extends AbstractAction {
        private int time;

        AddWorkoutSession() {
            super("Add a Workout Session");
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            JFrame newFrame = new JFrame("Making a Workout Session");

            JLabel initialLabel = new JLabel("Enter the following information: ");
            newFrame.add(initialLabel, BorderLayout.NORTH);

            JLabel timeLabel = new JLabel("Time (in mins): ");
            JTextField textField = new JTextField();
            textField.setSize(new Dimension(100, 30));
            newFrame.add(timeLabel, BorderLayout.WEST);
            newFrame.add(textField);

            textField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Get the text from the text field and do something with it
                    String text = textField.getText();
                    time = Integer.parseInt(text);
                }
            });



            newFrame.setSize(900, 700);
            newFrame.setVisible(true);
        }
    }
}
