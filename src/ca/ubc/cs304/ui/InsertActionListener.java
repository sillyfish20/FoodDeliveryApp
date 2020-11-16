package ca.ubc.cs304.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class InsertActionListener implements ActionListener {
    private JFrame frame;
    // list of attribute text fields related to selected table
    private List<JTextField> attrFields;

    /**
     * Receives the DatabaseUI frame so we can retrieve the attribute text field values
     * @param frame the DatabaseUI frame
     */
    public InsertActionListener(JFrame frame) {
        this.frame = frame;
    }

    /**
     * When insert button is clicked, it sends information from the text boxes into
     * the corresponding DBTransactions/DBConnectionHandler method
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // do something when insert button is clicked
        System.out.println("Insert tuple into table");
    }
}
