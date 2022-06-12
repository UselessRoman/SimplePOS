package com.wjc.domain;

import com.wjc.UI.SaleUI;
import com.wjc.config.SpringConfig;
import com.wjc.service.GoodService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sale extends SaleUI {

    ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

    GoodService goodService = ctx.getBean(GoodService.class);

    //超市的货物列表
    List<Good> goods = new ArrayList<>();

    //购物车
    Map<Good, Integer> shopping = new HashMap<>();

    //超市名
    String name;

    public Sale(String name) {

        this.name = name;

        initGoods();

        frame.setTitle(name + " SuperMarket");

        buyButton.addActionListener(e -> buy());

        clearButton.addActionListener(e -> {
            shoppinglistModel.clear();
            shopping.clear();
        });

        exitButton.addActionListener(e -> System.exit(0));

        goodsList.addListSelectionListener(e -> {
            int index = goodsList.getSelectedIndex();

            if (goodsList.getValueIsAdjusting()) {
                Good tempGood = goods.get(index);
                int num;
                if (shopping.get(tempGood) != null) num = shopping.get(tempGood) + 1;
                else num = 1;

                shopping.put(tempGood, num);
                shoppinglistModel.removeElement(tempGood.showWithNum(num - 1));
                shoppinglistModel.addElement(tempGood.showWithNum(num));
            }

        });
    }


    //从数据库中读取超市的货物列表
    public void initGoods() {

        goods = goodService.findGoodsBySupermarket(name);

        for (Good good : goods) {
            {
                goodslistModel.addElement(good);
            }
        }
    }

    //购买，并生成超市对应的订单
    public void buy() {
        frame.dispose();
        Receipt receipt;
        switch (name) {
            case "Hongqi" -> receipt = new HongqiReceipt(shopping);
            case "Hualian" -> receipt = new HualianReceipt(shopping);
            default -> {
                System.exit(0);
            }
        }
    }

}
