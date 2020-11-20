package ca.ubc.cs304.ui;

import ca.ubc.cs304.controller.FoodDeliveryApp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * This class creates the main app frame containing buttons for DML and SQL queries
 */

public class DatabaseAppUI extends JFrame {
    private JPanel container;
    private InsertUI insertUI;
    private DeleteUI deleteUI;
    private UpdateUI updateUI;
    private DisplayUI displayUI;
    private JoinUI joinUI;
    private SelectionUI selectionUI;
    private DivisionUI divisionUI;
    private HavingUI havingUI;
    private AggGroupByUI aggGroupByUI;
    private NestedAggregationGroupByUI nestedAggregationGroupByUI;

    public DatabaseAppUI() {
        super("Food Delivery App");
        this.container = new JPanel();
        container.setPreferredSize(new Dimension(400, 300));
        insertUI = new InsertUI();
        deleteUI = new DeleteUI();
        updateUI = new UpdateUI();
        displayUI = new DisplayUI();
        joinUI = new JoinUI();
        selectionUI = new SelectionUI();
        divisionUI = new DivisionUI();
        havingUI = new HavingUI();
        aggGroupByUI = new AggGroupByUI();
        nestedAggregationGroupByUI = new NestedAggregationGroupByUI();
    }

    /**
     * Displays a window that contains buttons that will open another window
     * Insert, Delete, Update, Display, Selection, Projection, Join, Agg. Group By, Agg. Having,
     * Nested Agg. Group By, DivisionUI
     * 5 rows 2 columns
     */
    public void showFrame() {
        JPanel controllerPanel = new JPanel();
        controllerPanel.setLayout(new GridLayout(5, 2));
        controllerPanel.setPreferredSize(new Dimension(400, 300));
        controllerPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        // Buttons for each query selection window
        JButton insert = new JButton("Insert");
        JButton delete = new JButton("Delete");
        JButton update = new JButton("Update");
        JButton select = new JButton("Select");
        JButton join = new JButton("Join/Project");
        JButton aggGroupBy = new JButton("Agg. Group By");
        JButton aggHaving = new JButton("Agg. Having");
        JButton nestedAggGroupBy = new JButton("Nested Agg. Group By");
        JButton division = new JButton("Division");
        JButton display = new JButton("Display Table");

        // Add Action listener to each button that will display the new window
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertUI.showFrame();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUI.showFrame();
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUI.showFrame();
            }
        });
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayUI.showFrame();
            }
        });
        join.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                joinUI.showFrame();
            }
        });
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectionUI.showFrame();
            }
        });
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                divisionUI.showFrame();
            }
        });
        aggHaving.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                havingUI.showFrame();
            }
        });
        aggGroupBy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aggGroupByUI.showFrame();
            }
        });
        nestedAggGroupBy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nestedAggregationGroupByUI.showFrame();
            }
        });

        // Add components to the controller panel
        controllerPanel.add(insert);
        controllerPanel.add(delete);
        controllerPanel.add(update);
        controllerPanel.add(select);
        controllerPanel.add(join);
        controllerPanel.add(aggGroupBy);
        controllerPanel.add(aggHaving);
        controllerPanel.add(nestedAggGroupBy);
        controllerPanel.add(division);
        controllerPanel.add(display);
        container.add(controllerPanel);

        // Display the frame
        this.add(container);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        // closes the connection before exiting the application
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FoodDeliveryApp.dbTransactions.closeConnection();
            }
        });
    }

}
