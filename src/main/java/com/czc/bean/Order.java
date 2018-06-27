package com.czc.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


/**
 * ClassName:Order
 * Description:
 */
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private String id;

    private double total;

    private Date date;


    //0未支付 ,1....
    private int status;
    private String uid;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "oid")
    private List<OrderItem> orderItems;
}
