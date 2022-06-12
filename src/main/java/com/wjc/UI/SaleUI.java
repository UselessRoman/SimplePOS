package com.wjc.UI;

import com.wjc.domain.Good;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SaleUI {
    protected JFrame frame;

    protected JPanel buttonPanel; //按键面板

    protected JSplitPane centerSplitPanel;        //分隔面板
    protected JScrollPane goodsPanel,              //货物面板
            shoppingPanel;               //购物车面板
    protected JList goodsList,
            shoppingList;                     //货物列表与购物车列表

    protected JButton buyButton,
            clearButton,exitButton;  //购买按键与清空按键

    protected DefaultListModel<Good> goodslistModel;
    protected DefaultListModel<String> shoppinglistModel;


    //构造函数
    public SaleUI() {
        initUI();
    }

    private void initUI() {

        //设置服务端窗口标题、默认大小以及布局
        frame = new JFrame("POS");
        frame.setSize(900, 600);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());


        goodslistModel = new DefaultListModel<>();
        shoppinglistModel = new DefaultListModel<>();


        goodsList = new JList(goodslistModel);
        goodsPanel = new JScrollPane(goodsList);
        goodsPanel.setBorder(new TitledBorder("所有货物"));


        shoppingList = new JList(shoppinglistModel);
        shoppingPanel = new JScrollPane(shoppingList);
        shoppingPanel.setBorder(new TitledBorder("购物车"));

        //将中间在线用户面板与接收消息面板组合起来
        centerSplitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, goodsPanel, shoppingPanel);
        centerSplitPanel.setDividerLocation(450);  //设置分隔线离左边450px

        buyButton = new JButton("购买");
        clearButton = new JButton("清空");
        exitButton=new JButton("退出");

        buttonPanel = new JPanel();

        buttonPanel.add(buyButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);


        frame.add(centerSplitPanel, "Center");
        frame.add(buttonPanel, "South");
        frame.setVisible(true);




    }


}
