package ca.ubc.cs304.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class InsertTableItemListener implements ItemListener {
    private static final int TEXT_FIELD_WIDTH = 10;
    private static final String CUSTOMER_TABLE = "Customer";
    private static final String VENDOR_TABLE = "Vendor";
    private static final String DRIVERS_TABLE = "Drivers";
    JPanel attrPanel;


    /**
     * Receives panel containing insert fields so we can add modify it
     * based on the table value selected by the user
     * @param panel The attribute panel
     */
    public InsertTableItemListener(JPanel panel) {
        this.attrPanel = panel;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox dropDownList = (JComboBox) e.getSource();
            String selectedTable = (String) dropDownList.getSelectedItem();
            System.out.println("Table selected: " + selectedTable);

            updateAttrPanel(selectedTable);
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
        JTextField custIDText = new JTextField(TEXT_FIELD_WIDTH);
        JLabel custNameLabel = new JLabel("Customer name:");
        JTextField custNameText = new JTextField(TEXT_FIELD_WIDTH);
        JLabel emailLabel =  new JLabel("Email: ");
        JTextField emailText = new JTextField(TEXT_FIELD_WIDTH);

        // The last 4 might not be necessary
        JLabel paymentInfoLabel = new JLabel("Payment Info: ");
        JLabel pointsLabel = new JLabel("Points: ");
        JLabel trialStartDateLabel = new JLabel("Trial Start Date: ");
        JLabel membershipLevelLabel = new JLabel("Membership Level: ");

        // layout components using the GridBag layout manager
        attrPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
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
}
