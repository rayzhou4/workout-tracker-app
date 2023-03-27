package ui.gui.popups;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupNotification extends JFrame {
    private JButton closeButton;
    private JPanel mainPanel;
    private JTextArea message;

    public PopupNotification() {
        setFrame();

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void setFrame() {
        setContentPane(mainPanel);
        setTitle("Error Message");
        setSize(300,250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        message.setLineWrap(true);
        message.setWrapStyleWord(true);
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }
}

