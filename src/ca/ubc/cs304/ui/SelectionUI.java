package ca.ubc.cs304.ui;

import ca.ubc.cs304.controller.FoodDeliveryApp;
import ca.ubc.cs304.model.OrderAnalysis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

public class SelectionUI extends JFrame implements ActionListener {
    private static final int TEXT_FIELD_WIDTH = 10;
    private JPanel container;
    private JTextField subTotalField;

    public SelectionUI() {
        super("Selection Query");
        this.container = new JPanel();
        container.setPreferredSize(new Dimension(300, 300));
    }

    public void showFrame() {
        JPanel selectionPanel = new JPanel();
        // set layout
        selectionPanel.setLayout(new GridBagLayout());
        selectionPanel.setPreferredSize(new Dimension(300, 300));
        selectionPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        // add labels, fields, button
        String text = "Find orderID and subtotals for orders with a subtotal greater than:";
        JTextArea subTotalLabel = new JTextArea(2, 20);
        subTotalLabel.setPreferredSize(new Dimension(275, 30));
        subTotalLabel.setText(text);
        subTotalLabel.setWrapStyleWord(true);
        subTotalLabel.setLineWrap(true);
        subTotalLabel.setOpaque(false);
        subTotalLabel.setEditable(false);
        subTotalLabel.setFocusable(false);
        subTotalLabel.setBackground(UIManager.getColor("Label.background"));
        subTotalLabel.setFont(UIManager.getFont("Label.font"));
        subTotalLabel.setBorder(UIManager.getBorder("Label.border"));
        subTotalField = new JTextField(TEXT_FIELD_WIDTH);
        JButton submitQuery = new JButton("Submit Query");
        submitQuery.addActionListener(this);

        // add formatting and add components to panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 5,0,0);
        selectionPanel.add(subTotalLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        selectionPanel.add(subTotalField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0,0,0);
        selectionPanel.add(submitQuery, gbc);
        // display the frame
        container.add(selectionPanel);
        this.add(container);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Submit Query button clicked!");
        // get the value from the text box
        try {
            BigDecimal subTotalValue = new BigDecimal(subTotalField.getText());
            ArrayList<OrderAnalysis> results = FoodDeliveryApp.dbTransactions.handleSelectionQuery(subTotalValue);

        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "The subtotal must be a number!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
