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
    //private BookShelfGUI bookShelfPanel = new BookShelfGUI();
    //private ReadingListGUI readingListPanel = new ReadingListGUI();
    private MainMenuGUI mainMenuGUI = new MainMenuGUI();
    protected static CardLayout cardLayout = new CardLayout();

    public WorkoutAppGUI() {
        startApp();
    }

    private void setFrame() {
        frame = new JFrame();

        ImageIcon icon = new ImageIcon("./data/Images/Icon.jpg");
        frame.setIconImage(icon.getImage());

        frame.setLayout(cardLayout);
        frame.add(mainMenuGUI, "main menu");
        //frame.add(bookShelfPanel, "bookshelf");
        //frame.add(readingListPanel, "reading list");
        cardLayout.show(frame.getContentPane(), "main menu");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Personal Library");
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }


    private void startApp() {
        setFrame();
    }
}
