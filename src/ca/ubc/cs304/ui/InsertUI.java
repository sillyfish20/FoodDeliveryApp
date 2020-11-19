package ca.ubc.cs304.ui;

import javax.swing.*;
import java.awt.*;

public class InsertUI extends JFrame {
    private JPanel container;

    public InsertUI() {
        super("Insert into Table");
        this.container = new JPanel();
        container.setPreferredSize(new Dimension(300, 200));
    }

    public void showFrame() {
        container.removeAll();
        JPanel insertPanel = new JPanel();
        insertPanel.setLayout(new BoxLayout(insertPanel, BoxLayout.PAGE_AXIS));
        insertPanel.setPreferredSize(new Dimension(300, 200));
        insertPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        JLabel insertTableLabel = new JLabel("Select Table: ");
        String[] tables = {"", "Customer", "Vendor", "Drivers"};
        JComboBox tableDropDown = new JComboBox(tables);
        JPanel attrPanel = new JPanel();
        JButton insertButton = new JButton("Insert");
        InsertTableItemActionListener insertTableItemActionListener = new InsertTableItemActionListener(attrPanel);
        tableDropDown.addItemListener(insertTableItemActionListener);
        insertButton.addActionListener(insertTableItemActionListener);
        insertPanel.add(insertTableLabel);
        insertPanel.add(tableDropDown);
        insertPanel.add(attrPanel);
        insertPanel.add(insertButton);
        container.add(insertPanel);

        // Display the frame
        this.add(container);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
