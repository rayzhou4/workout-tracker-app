package ui.gui.popups;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUI class for the popup notification page
public class PopupNotification extends JFrame {
    private JButton closeButton;
    private JPanel mainPanel;
    private JTextArea message;

    // MODIFIES: this
    // EFFECTS: constructor; sets the GUI for the popup notification page
    public PopupNotification() {
        setFrame();

        closeButtonActionListener();
    }

    // MODIFIES: this
    // EFFECTS: sets the frame for the GUI
    private void setFrame() {
        message.setLineWrap(true);
        message.setWrapStyleWord(true);

        setContentPane(mainPanel);
        setTitle("Error Message");
        setSize(300,250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: sets a message on the popup notification frame
    public void setMessage(String message) {
        this.message.setText(message);
    }

    // MODIFIES: this
    // EFFECTS: action listener method for the close button; disposes the frame
    private void closeButtonActionListener() {
        closeButton.addActionListener(new ActionListener() {
            // MODIFIES: this
            // EFFECTS: gives the button the ability to dispose the frame
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}

