package com.wjc.domain;

public class Good {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "  " + price + "元/件";
    }

    public String showWithNum(int num) {
        return name + "X" + num;
    }

    public String showWithTotalPrice(int num)
    {
        return name+"  单价："+price+"元/件  "+"数量："+num+"  总价："+num*price+"元";
    }
}
