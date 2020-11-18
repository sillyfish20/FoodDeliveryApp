package ca.ubc.cs304.ui;

import ca.ubc.cs304.controller.FoodDeliveryApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayUI extends JFrame implements ActionListener {
    private JPanel container;
    private JComboBox tableDropDown;
    private JPanel tablePanel;

    public DisplayUI() {
        super("Display Tables");
        this.container = new JPanel();
        container.setPreferredSize(new Dimension(500, 500));
    }

    public void showFrame() {
        JPanel displayPanel = new JPanel();
        // set layout
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.setPreferredSize(new Dimension(500, 500));
        displayPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        // set labels, fields, buttons
        JLabel displayLabel = new JLabel("Select table to display:");
        String[] tables = {"Customer", "Vendor", "ManagesRestaurant", "Drivers", "Drivers_Vehicle", "Food",
                "Serves", "RestaurantLocation", "AreaCode", "Transactions", "Receipt", "RequestsOrder", "MakesOrder",
                "PicksUpOrder", "DeliversTo", "OrderDestination", "RequestsAddress", "AddressDestination",
                "MembershipInfo", "TrialRange"};
        tableDropDown = new JComboBox(tables);
        JButton displayButton = new JButton("Display");
        tablePanel = new JPanel();
        displayButton.addActionListener(this);

        // add formatting and add components to panel
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.gridx = 0;
//        gbc.gridy = 0;
        //gbc.insets = new Insets(20, 0,0,0);
        displayPanel.add(displayLabel);
//        gbc.gridx = 0;
//        gbc.gridy = 1;
        //gbc.insets.top = 10;
        displayPanel.add(tableDropDown);
//        gbc.gridx = 0;
//        gbc.gridy = 2;
        //gbc.insets.top = 30;
        displayPanel.add(displayButton);
        displayPanel.add(tablePanel);

        // Display the frame
        container.add(displayPanel);
        this.add(container);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // get the selected table from table drop down
        String table = (String) tableDropDown.getSelectedItem();
        // send the SELECT * query for the table
        FoodDeliveryApp.dbTransactions.handleDisplay(table);
        // receive the table data and display it
        displayTable();
    }

    private void displayTable() {
        // display the table with retrieved data
    }
}
