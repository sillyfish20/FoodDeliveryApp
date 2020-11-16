package ca.ubc.cs304.ui;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class InsertTableItemListener implements ItemListener {
    JPanel attrPanel;


    /**
     * Receives panel containing insert fields so we can add modify it
     * based on the table value selected by the user
     * @param panel The attribute panel
     */
    public InsertTableItemListener(JPanel panel) {
        this.attrPanel = panel;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox dropDownList = (JComboBox) e.getSource();
            System.out.println("Table selected: " + dropDownList.getSelectedItem());
        }

    }

    /**
     * Updates the attribute fields panel to display attribute fields
     * corresponding to the table selected
     */
    private void updateAttrPanel() {
        // display attribute fields
        attrPanel.removeAll();
        // add new attribute fields
        attrPanel.revalidate();
        attrPanel.repaint();
    }
}
