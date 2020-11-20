package ca.ubc.cs304.ui;

import ca.ubc.cs304.controller.FoodDeliveryApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HavingUI extends JFrame implements ActionListener {
    private JPanel container;
    private JPanel tablePanel;

    public HavingUI() {
        super("Group By Having Query");
        this.container = new JPanel();
        container.setPreferredSize(new Dimension(350, 375));
    }

    public void showFrame() {
        container.removeAll();
        JPanel havingPanel = new JPanel();
        // set layout
        havingPanel.setLayout(new GridBagLayout());
        havingPanel.setPreferredSize(new Dimension(300, 150));
        havingPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        // add labels, fields, button
        String text = "Find customers that have made more than 5 orders with an average subtotal greater than $50:";
        JTextArea havingQueryLabel = new JTextArea(3, 20);
        havingQueryLabel.setPreferredSize(new Dimension(275, 30));
        havingQueryLabel.setText(text);
        havingQueryLabel.setWrapStyleWord(true);
        havingQueryLabel.setLineWrap(true);
        havingQueryLabel.setOpaque(false);
        havingQueryLabel.setEditable(false);
        havingQueryLabel.setFocusable(false);
        havingQueryLabel.setBackground(UIManager.getColor("Label.background"));
        havingQueryLabel.setFont(UIManager.getFont("Label.font"));
        havingQueryLabel.setBorder(UIManager.getBorder("Label.border"));
        JButton submitQuery = new JButton("Submit Query");
        submitQuery.addActionListener(this);
        tablePanel = new JPanel();

        // add formatting and add components to panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 5,0,0);
        havingPanel.add(havingQueryLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0,0,0);
        havingPanel.add(submitQuery, gbc);
        // display the frame
        container.add(havingPanel);
        container.add(tablePanel);
        this.add(container);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Submit query button was clicked!");
        tablePanel.removeAll();
        // get query results
        ArrayList<Integer> results = FoodDeliveryApp.dbTransactions.handleAggrHavingQuery();
        String[] columnNames = {"CustomerID"};
        Object[][] data = new Object[results.size()][];
        //put query results is 2D object array format
        for (int i = 0; i < results.size(); i++) {
            int customerID = results.get(i);
            Object[] rowData = {customerID};
            data[i] = rowData;
        }

        JTable table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 150);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(300, 150));
        // display the table
        tablePanel.add(scrollPane);
        this.revalidate();
        this.repaint();
        ((JFrame) SwingUtilities.getRoot(container)).pack();
    }
}
