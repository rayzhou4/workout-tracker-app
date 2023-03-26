package ui.gui.popups;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputError extends JFrame {
    private JButton closeButton;
    private JLabel errorMessage;
    private JPanel mainPanel;

    public InputError() {
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
        setSize(250,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setErrorMessage(String message) {
        errorMessage.setText(message);
    }
}

