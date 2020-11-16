package ca.ubc.cs304.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DatabaseUI extends JFrame implements ActionListener, ItemListener {
    private static final int TEXT_FIELD_WIDTH = 20;
    private JPanel container;

    private DatabaseTransactions dbTransactions = null;

    public DatabaseUI() {
        super("Food Delivery App");
        this.container = new JPanel();
    }

    public void showFrame(DatabaseTransactions dbTransactions) {
        this.dbTransactions = dbTransactions;
        // INSERT //
        JPanel insertPanel = new JPanel();
        insertPanel.setBorder(BorderFactory.createTitledBorder("Insert into a table"));
        insertPanel.setLayout(new GridLayout(4, 2, 1, 1));
        JLabel insertTableLabel = new JLabel("Select Table: ", SwingConstants.LEFT);
        String[] tables = {"", "Customer", "Vendor", "Drivers"};
        JComboBox tableDropDown = new JComboBox(tables);
        JPanel attrPanel = new JPanel();
        JButton insertButton = new JButton("Insert");
        InsertTableItemListener insertTableItemListener = new InsertTableItemListener(attrPanel);
        tableDropDown.addItemListener(insertTableItemListener);
        InsertActionListener insertActionListener = new InsertActionListener(this);
        insertButton.addActionListener(insertActionListener);

        insertPanel.setPreferredSize(new Dimension(200, 200));
        insertPanel.add(insertTableLabel);
        insertPanel.add(tableDropDown);
        insertPanel.add(attrPanel);
        insertPanel.add(insertButton);
        container.add(insertPanel);

        // UPDATE


        // DELETE

        this.add(container, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    /**
    * ActionListener Methods
     * if button is pressed
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        //
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
