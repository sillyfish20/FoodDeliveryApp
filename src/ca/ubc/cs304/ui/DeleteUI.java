package ca.ubc.cs304.ui;

import ca.ubc.cs304.controller.FoodDeliveryApp;
import ca.ubc.cs304.database.DatabaseConnectionHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUI extends JFrame implements ActionListener {
    private static final int TEXT_FIELD_WIDTH = 10;
    private JPanel container;
    // this is a global field so we can access the text value
    private JTextField driverIDInput;

    public DeleteUI() {
        super("Delete Driver");
        this.container = new JPanel();
        container.setPreferredSize(new Dimension(300, 210));
    }

    /**  Since delete is very simple compared to insert, handle ActionListener in this class
     *   instead of creating another class
     */
    public void showFrame() {
        JPanel deletePanel = new JPanel();
        deletePanel.setLayout(new GridBagLayout());
        deletePanel.setPreferredSize(new Dimension(300, 200));
        deletePanel.setBorder(BorderFactory.createTitledBorder("Delete a Driver"));
        JLabel deleteDriverLabel = new JLabel("Driver ID to delete: ");
        driverIDInput = new JTextField(TEXT_FIELD_WIDTH);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        deletePanel.add(deleteDriverLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        deletePanel.add(driverIDInput, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        deletePanel.add(deleteButton, gbc);
        container.add(deletePanel, gbc);

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
        try {
            // get text input
            int driverID = Integer.parseInt(driverIDInput.getText());
            // handle the delete query
            System.out.println("Sending driverID to delete query handler");
            FoodDeliveryApp.dbTransactions.handleDelete(driverID);
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Driver ID should be an integer!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
