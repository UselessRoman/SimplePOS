package com.wjc.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class HongqiReceipt extends Receipt {
    public HongqiReceipt(Map<Good, Integer> shopping) {
        super(shopping);
        frame.setTitle("红旗超市购物小票");

        receiptListModel.addElement("红旗超市欢迎您再次光临！");

    }

    @Override
    void printReceipt() {
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

        String fileName = "D:\\Projects\\java\\POS\\src\\main.java.com.wjc.files\\receipts\\HongqiReceipt" + dateformat.format(date) + ".txt";

        write(fileName);
        new Sale("Hongqi");
    }
}
