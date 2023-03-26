package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JPanel implements ActionListener {

    private JButton toBookShelf = new JButton("Bookshelf");
    private JPanel sideBar;
    private JButton toReadingList = new JButton("Reading List");

    public MainMenuGUI() {
        setSideBarMainMenu();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1000, 760));
        this.setBackground(Color.decode("#2a4b5f"));
        this.add(sideBar);

        toBookShelf.setBounds(75, 280, 100, 30);
        sideBar.add(toBookShelf);

        toReadingList.setBounds(60, 400, 130, 30);
        sideBar.add(toReadingList);

        toBookShelf.addActionListener(this);
        toReadingList.addActionListener(this);
    }

    private void setSideBarMainMenu() {
        sideBar = new JPanel(null);
        sideBar.setSize(250, 760);
        sideBar.setBackground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) this.getRootPane().getParent();

        if (e.getSource() == toBookShelf) {
            WorkoutAppGUI.cardLayout.show(frame.getContentPane(),"bookshelf");
        } else if (e.getSource() == toReadingList) {
            WorkoutAppGUI.cardLayout.show(frame.getContentPane(),"reading list");
        }
    }
}
