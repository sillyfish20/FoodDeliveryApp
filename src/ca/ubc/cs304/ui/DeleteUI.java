package ca.ubc.cs304.ui;

import ca.ubc.cs304.database.DatabaseConnectionHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUI extends JFrame implements ActionListener {
    private DatabaseConnectionHandler dbConnHandler;
    private static final int TEXT_FIELD_WIDTH = 10;
    private JPanel container;
    // this is a global field so we can access the text value
    private JTextField driverIDInput;

    public DeleteUI() {
        super("Delete Driver");
        this.container = new JPanel();
        container.setPreferredSize(new Dimension(300, 300));
    }

    // TODO: Since delete is very simple compared to insert, handle ActionListener in this class
    //      instead of in another class
    public void showFrame() {
        JPanel deletePanel = new JPanel();
        deletePanel.setLayout(new BoxLayout(deletePanel, BoxLayout.PAGE_AXIS));
        deletePanel.setPreferredSize(new Dimension(300, 300));
        deletePanel.setBorder(BorderFactory.createTitledBorder("Delete a Driver"));
        JLabel deleteDriverLabel = new JLabel("Driver ID to delete: ");
        driverIDInput = new JTextField(TEXT_FIELD_WIDTH);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);

        deletePanel.add(deleteDriverLabel);
        deletePanel.add(driverIDInput);
        deletePanel.add(deleteButton);
        container.add(deletePanel);

        // Display the frame
        this.add(container);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    /**
     * When user clicks Delete button, send the text input from the driverIDInput TJTextField
     * and send it to the databaseConnectionHandler to handle the delete query
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // get text input
        String driverID = driverIDInput.getText();
        // TODO: call the method that handles sending the query
    }
}
