package ca.ubc.cs304.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class DatabaseUI extends JFrame implements ActionListener, ItemListener {
    private static final int TEXT_FIELD_WIDTH = 20;
    private JPanel container;

    private DatabaseTransactions dbTransactions = null;

    public DatabaseUI() {
        super("Food Delivery App");
        this.container = new JPanel();
        container.setPreferredSize(new Dimension(500, 500));
    }

    public void showFrame(DatabaseTransactions dbTransactions) {
        this.dbTransactions = dbTransactions;
        // INSERT //
        JPanel insertPanel = new JPanel();
        insertPanel.setLayout(new BoxLayout(insertPanel, BoxLayout.PAGE_AXIS));
        insertPanel.setPreferredSize(new Dimension(400, 300));
        insertPanel.setBorder(BorderFactory.createTitledBorder("Insert tuple into Table"));
        JLabel insertTableLabel = new JLabel("Select Table: ");
        String[] tables = {"", "Customer", "Vendor", "Drivers"};
        JComboBox tableDropDown = new JComboBox(tables);
        JPanel attrPanel = new JPanel();
        JButton insertButton = new JButton("Insert");
        InsertTableItemListener insertTableItemListener = new InsertTableItemListener(attrPanel);
        tableDropDown.addItemListener(insertTableItemListener);
        InsertActionListener insertActionListener = new InsertActionListener(this);
        insertButton.addActionListener(insertActionListener);
        insertPanel.add(insertTableLabel);
        insertPanel.add(tableDropDown);
        insertPanel.add(attrPanel);
        insertPanel.add(insertButton);
        container.add(insertPanel);

        // UPDATE


        // DELETE

        this.add(container);
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
