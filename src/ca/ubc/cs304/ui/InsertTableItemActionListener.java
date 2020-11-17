package ca.ubc.cs304.ui;

import ca.ubc.cs304.controller.FoodDeliveryApp;
import ca.ubc.cs304.model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class InsertTableItemActionListener implements ItemListener, ActionListener {
    private static final int TEXT_FIELD_WIDTH = 10;
    private static final String CUSTOMER_TABLE = "Customer";
    private static final String VENDOR_TABLE = "Vendor";
    private static final String DRIVERS_TABLE = "Drivers";
    private JPanel attrPanel;
    private String selectedTable = null;
    private JTextField custIDText;
    private JTextField custNameText;
    private JTextField emailText;
    private GridBagConstraints gbc;



    /**
     * Receives panel containing insert fields so we can add modify it
     * based on the table value selected by the user
     * @param panel The attribute panel
     */
    public InsertTableItemActionListener(JPanel panel) {
        this.attrPanel = panel;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof JComboBox) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                JComboBox dropDownList = (JComboBox) e.getSource();
                selectedTable = (String) dropDownList.getSelectedItem();
                System.out.println("Table selected: " + selectedTable);

                updateAttrPanel(selectedTable);
            }
        }

    }

    /**
     * Updates the attribute fields panel to display attribute fields
     * corresponding to the table selected
     */
    private void updateAttrPanel(String table) {
        attrPanel.removeAll();
        if (table.equals(CUSTOMER_TABLE)) {
            updateToCustomerTable();
        } else if (table.equals(VENDOR_TABLE)) {
            // updateToVendorTable
            // do this if have time lol
        }

        // add new attribute fields
        attrPanel.revalidate();
        attrPanel.repaint();
        attrPanel.getParent().revalidate();
        attrPanel.getParent().repaint();
        ((JFrame) SwingUtilities.getRoot(attrPanel)).pack();
    }

    private void updateToCustomerTable() {
        // display customer related attributes
        JLabel custIDLabel = new JLabel("Customer ID:");
        custIDText = new JTextField(TEXT_FIELD_WIDTH);
        JLabel custNameLabel = new JLabel("Customer name:");
        custNameText = new JTextField(TEXT_FIELD_WIDTH);
        JLabel emailLabel =  new JLabel("Email: ");
        emailText = new JTextField(TEXT_FIELD_WIDTH);

        // These 4 attributes might not be necessary
        JLabel paymentInfoLabel = new JLabel("Payment Info: ");
        JLabel pointsLabel = new JLabel("Points: ");
        JLabel trialStartDateLabel = new JLabel("Trial Start Date: ");
        JLabel membershipLevelLabel = new JLabel("Membership Level: ");

        // layout components using the GridBag layout manager
        attrPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        attrPanel.add(custIDLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        attrPanel.add(custIDText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        attrPanel.add(custNameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        attrPanel.add(custNameText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        attrPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        attrPanel.add(emailText, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            // do something when insert button is clicked
            System.out.println("Insert tuple into table");
            // create the table object and pass it into DatabaseTransactions
            // find out which table was selected
            if (selectedTable.equals(CUSTOMER_TABLE)) {
                Customer customer = null;
                try {
                    customer = createCustomerObj();
                } catch (Exception err) {
                    JLabel errorLabel = new JLabel("There was an error in the input");
                    gbc.gridwidth = 2;
                    gbc.gridx = 0;
                    gbc.gridy = 3;
                    gbc.anchor = GridBagConstraints.PAGE_END;
                    attrPanel.add(errorLabel, gbc);
                    attrPanel.revalidate();
                    attrPanel.repaint();
                }
                // send customer object an insert query in databaseConnectionHandler
                System.out.println("Sending Customer object to insert query");
                if (customer != null) {
                    // TODO: send the query if the customer object is not null
                    FoodDeliveryApp.dbTransactions.handleInsert(customer);
                }
            }
        }
    }

    // creates a Customer table object
    private Customer createCustomerObj() throws Exception {
        // get the customer attributes from JComponents
        Customer customer = null;
        try {
            int custID = Integer.parseInt(custIDText.getText());
            String custName = custNameText.getText();
            String email = emailText.getText();

            customer = new Customer(custID, custName, email,
                    null, 0, null, 0);
            System.out.println("Creating Customer object");
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
        return customer;
    }
}
