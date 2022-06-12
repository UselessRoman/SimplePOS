package com.wjc.UI;

import javax.swing.*;
import java.awt.*;

public class ReceiptUI {
    protected JFrame frame;

    protected JPanel buttonPanel;
    protected JScrollPane receiptPanel;

    protected JList receiptList;

    protected JButton printButton, cancelButton;

    protected DefaultListModel<String> receiptListModel;

    public ReceiptUI() {
        initUI();
    }

    private void initUI() {
        frame = new JFrame("小票");
        frame.setSize(450, 600);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        receiptListModel = new DefaultListModel<>();

        receiptList = new JList(receiptListModel);

        receiptPanel = new JScrollPane(receiptList);

        buttonPanel = new JPanel();

        printButton = new JButton("确认");
        cancelButton = new JButton("取消");
        buttonPanel.add(printButton);
        buttonPanel.add(cancelButton);

        frame.add(receiptPanel, "Center");
        frame.add(buttonPanel, "South");
        frame.setVisible(true);


    }
}
