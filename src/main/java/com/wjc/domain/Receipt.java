package com.wjc.domain;


import com.wjc.UI.ReceiptUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Receipt extends ReceiptUI {

    //客户购买的货物
    Map<Good, Integer> shopping = new HashMap<>();

    double price = 0;

    public Receipt(Map<Good, Integer> shopping) {
        receiptListModel.addElement(String.valueOf(new Date()));
        receiptListModel.addElement("                ");
        for (Map.Entry<Good, Integer> entry : shopping.entrySet()) {
            int num = entry.getValue();
            Good good = entry.getKey();
            receiptListModel.addElement(good.showWithTotalPrice(num));
            price += good.getPrice() * num;
        }
        receiptListModel.addElement("总计：" + price + "元");


        printButton.addActionListener(e -> printReceipt());

        cancelButton.addActionListener(e -> System.exit(0));
    }

    //打印小票，即输出为文件
    abstract void printReceipt();

    void write(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < receiptListModel.size(); i++) {
                writer.write(receiptListModel.get(i) + "\n");

            }
            writer.close();
            frame.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
