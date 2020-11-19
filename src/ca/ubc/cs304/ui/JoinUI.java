package ca.ubc.cs304.ui;

import javax.swing.*;
import java.awt.*;

public class JoinUI extends JFrame {
    private static final int TEXT_FIELD_WIDTH = 10;
    private JPanel container;

    public JoinUI() {
        super("Join and Project");
        this.container = new JPanel();
        container.setPreferredSize(new Dimension(300, 300));
    }

    public void showFrame() {
        JPanel joinPanel = new JPanel();
        joinPanel.setLayout(new BoxLayout(joinPanel, BoxLayout.PAGE_AXIS));
        joinPanel.setPreferredSize(new Dimension(300, 300));
        joinPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        container.add(joinPanel);
        this.add(container);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
