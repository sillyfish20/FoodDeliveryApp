package ca.ubc.cs304.ui;

import ca.ubc.cs304.delegates.LoginWindowDelegate;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DatabaseUI extends JFrame implements ActionListener {
    public DatabaseUI() {
        //TODO: update name
        super("Food Delivery App");
    }

    public void showFrame(LoginWindowDelegate delegate) {
        //
    }

    /**
    * ActionListener Methods
     * if button is pressed
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        //
    }
}
