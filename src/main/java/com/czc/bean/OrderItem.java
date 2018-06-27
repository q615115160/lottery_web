package com.czc.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * ClassName:OrderItem
 * Description:
 */
@Data
@Entity(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue
    private int id;

    private String oid;
    private String red;
    private String blue;
    private double price = 2;
    private int count;
    private double subTotal;

    public double getSubTotal() {
        return price*count;
    }


}
