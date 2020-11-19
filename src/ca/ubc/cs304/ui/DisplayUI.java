package ca.ubc.cs304.ui;

import ca.ubc.cs304.controller.FoodDeliveryApp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayUI extends JFrame implements ActionListener {
    private static final int TABLE_COLUMN_COUNT = 6;
    private JPanel container;
    private JComboBox tableDropDown;
    private JPanel tablePanel;

    public DisplayUI() {
        super("Display Tables");
        this.container = new JPanel();
        container.setPreferredSize(new Dimension(510, 400));
    }

    public void showFrame() {
        container.removeAll();
        JPanel displayPanel = new JPanel();
        // set layout
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.setPreferredSize(new Dimension(300, 100));
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

        // add add components to panel
        displayPanel.add(displayLabel);
        displayPanel.add(tableDropDown);
        displayPanel.add(displayButton);

        // Display the frame
        container.add(displayPanel);
        container.add(tablePanel);
        this.add(container);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Display button clicked!");
        String selectedTable = (String) tableDropDown.getSelectedItem();
        DefaultTableModel tableModel = FoodDeliveryApp.dbTransactions.handleDisplay(selectedTable);
        displayTable(tableModel);
    }

    private void displayTable(DefaultTableModel tableModel) {
        tablePanel.removeAll();

        JTable table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // resize the column width if there are less columns
        if (table.getColumnCount() <= TABLE_COLUMN_COUNT) {
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 200));

        tablePanel.add(scrollPane);
        container.revalidate();
        container.repaint();
    }
}
