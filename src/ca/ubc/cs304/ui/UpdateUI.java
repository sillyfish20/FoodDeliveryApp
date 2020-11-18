package ca.ubc.cs304.ui;

import ca.ubc.cs304.controller.FoodDeliveryApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UpdateUI extends JFrame implements ActionListener {
    private static final int TEXT_FIELD_WIDTH = 10;
    private JPanel container;
    private JTextField custIDField;
    private JComboBox attrDropDown;
    private JTextField attrValueField;

    public UpdateUI() {
        super("Update Customer");
        this.container = new JPanel();
        container.setPreferredSize(new Dimension(300, 200));
    }

    public void showFrame() {
        JPanel updatePanel = new JPanel();
        // set layout
        updatePanel.setLayout(new GridBagLayout());
        updatePanel.setPreferredSize(new Dimension(300, 200));
        updatePanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        // set labels, inputs, and button
        JLabel custIDLabel = new JLabel("Select customer ID: ");
        custIDField = new JTextField(TEXT_FIELD_WIDTH);
        JLabel updateAttrLabel = new JLabel("Select customer field to update: ");
        String[] attributes = {"Name", "Email"};
        attrDropDown = new JComboBox(attributes);
        attrValueField = new JTextField(TEXT_FIELD_WIDTH);
        JButton updateButton = new JButton("Update");
        // add action listener to button
        updateButton.addActionListener(this);

        // add formatting and add components to panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        updatePanel.add(custIDLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        updatePanel.add(custIDField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        updatePanel.add(updateAttrLabel, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets.top = 5;
        updatePanel.add(attrDropDown, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        updatePanel.add(attrValueField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets.top = 20;
        updatePanel.add(updateButton, gbc);
        container.add(updatePanel);

        // Display the frame
        this.add(container);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    /**
     * When user clicks Update button, send the text input from the attribute value text field
     * along with specified attribute
     * and send it to the databaseConnectionHandler to handle the delete query
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Update button was clicked!");
        try {
            int custID = Integer.parseInt(custIDField.getText());
            String attr = (String) attrDropDown.getSelectedItem();
            String newValue = attrValueField.getText();
            if (attr.equals("Name")) {
                attr = "cName";
            }
            System.out.println("Sending custID, attr, and new value to update query handler");
            FoodDeliveryApp.dbTransactions.handleUpdate(custID, attr, newValue);
        } catch(NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Customer ID should be an integer!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
