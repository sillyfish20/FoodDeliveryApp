package ca.ubc.cs304.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class DatabaseAppUI extends JFrame {
    private JPanel container;
    private InsertUI insertUI = null;
    private DeleteUI deleteUI = null;

    public DatabaseAppUI() {
        super("Food Delivery App");
        this.container = new JPanel();
        container.setPreferredSize(new Dimension(400, 300));
        insertUI = new InsertUI();
        deleteUI = new DeleteUI();
    }

    /**
     * Displays a window that contains buttons that will open another window
     * Insert, Delete, Update, Display, Selection, Projection, Join, Agg. Group By, Agg. Having,
     * Nested Agg. Group By, Division
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
        JButton join = new JButton("Join");
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

}
