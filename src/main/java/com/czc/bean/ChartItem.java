package com.czc.bean;

import lombok.Data;

/**
 * ClassName:ChartItem
 * Description:
 */

@Data
public class ChartItem {

    private String red;
    private String blue;
    private double price=2;
    private int count;
    private double subTotal;

    public double getSubTotal() {
        return price*count;
    }
}
