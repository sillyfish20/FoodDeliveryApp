package ca.ubc.cs304.ui;

import ca.ubc.cs304.controller.FoodDeliveryApp;
import ca.ubc.cs304.model.Customer;
import ca.ubc.cs304.model.Drivers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class InsertTableItemActionListener implements ItemListener, ActionListener {
    private static final int TEXT_FIELD_WIDTH = 10;
    private static final String CUSTOMER_TABLE = "Customer";
    private static final String DRIVERS_TABLE = "Drivers";
    private JPanel attrPanel;
    private String selectedTable = null;
    private JTextField custIDText;
    private JTextField custNameText;
    private JTextField emailText;
    private JTextField driverIDText;
    private JTextField driverNameText;
    private JTextField licenseText;
    private JCheckBox recordApprovedBox;
    private GridBagConstraints gbc;

    /**
     * Receives s panel containing insert fields so we can add modify it
     * based on the table value selected by the user
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
        } else if (table.equals(DRIVERS_TABLE)) {
            updateToDriverTable();
        }

        // repaint the panel
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

        // These 4 attributes will not be necessary
//        JLabel paymentInfoLabel = new JLabel("Payment Info: ");
//        JLabel pointsLabel = new JLabel("Points: ");
//        JLabel trialStartDateLabel = new JLabel("Trial Start Date: ");
//        JLabel membershipLevelLabel = new JLabel("Membership Level: ");

        // layout components using the GridBag layout manager
        attrPanel.setPreferredSize(new Dimension(300, 150));
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

    private void updateToDriverTable() {
        // display driver related attributes
        JLabel driverIDLabel = new JLabel("Driver ID:");
        driverIDText = new JTextField(TEXT_FIELD_WIDTH);
        JLabel driverNameLabel = new JLabel("Driver name:");
        driverNameText = new JTextField(TEXT_FIELD_WIDTH);
        JLabel licenseLabel =  new JLabel("Drivers License: ");
        licenseText = new JTextField(TEXT_FIELD_WIDTH);
        JLabel recordApprovedLabel = new JLabel("Driving Record Approved?");
        recordApprovedBox = new JCheckBox();

        // layout components using the GridBag layout manager
        attrPanel.setPreferredSize(new Dimension(300, 150));
        attrPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        attrPanel.add(driverIDLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        attrPanel.add(driverIDText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        attrPanel.add(driverNameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        attrPanel.add(driverNameText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        attrPanel.add(licenseLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        attrPanel.add(licenseText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        attrPanel.add(recordApprovedLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        attrPanel.add(recordApprovedBox, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            System.out.println("Insert button clicked");
            if (selectedTable.equalsIgnoreCase(CUSTOMER_TABLE)) {
                Customer customer = createCustomerObj();
                if (customer != null) {
                    FoodDeliveryApp.dbTransactions.handleInsert(customer);
                }
            } else if (selectedTable.equalsIgnoreCase(DRIVERS_TABLE)) {
                Drivers driver = createDriverObj();
                if (driver != null) {
                    FoodDeliveryApp.dbTransactions.handleInsert(driver);
                }
            }
        }
    }


    // creates a Customer table object
    private Customer createCustomerObj() {
        // get the customer attributes from JComponents
        Customer customer = null;
        try {
            int custID = Integer.parseInt(custIDText.getText());
            String custName = custNameText.getText();
            String email = emailText.getText();

            customer = new Customer(custID, custName, email,
                    null, null, 0, 0);
            System.out.println("Creating Customer object");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Customer ID should be an integer!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return customer;
    }

    // creates a Driver table object
    private Drivers createDriverObj() {
        Drivers driver = null;
        try {
            int driverID = Integer.parseInt(driverIDText.getText());
            String driverName = driverNameText.getText();
            String license = licenseText.getText();
            int recordApproved = 0;
            if (recordApprovedBox.isSelected()) {
                recordApproved = 1;
            }

            driver = new Drivers(driverID, license, driverName, recordApproved);
            System.out.println("Creating Customer object");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Driver ID should be an integer!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return driver;
    }
}
