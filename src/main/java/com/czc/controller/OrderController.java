package com.czc.controller;

import com.czc.bean.Chart;
import com.czc.bean.ChartItem;
import com.czc.bean.Order;
import com.czc.bean.OrderItem;
import com.czc.bean.User;
import com.czc.service.OrderService;
import com.czc.utils.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * ClassName:OrderController
 * Description:
 */

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService mOrderService;

    @RequestMapping("/submit")
    public String submit(HttpSession session){

        //session中获取cart ,封装成order
        Chart chart = (Chart) session.getAttribute("chart");
        Order order = new Order();
        order.setId(UUIDUtils.getId());
        order.setDate(new Date());
        order.setTotal(chart.getTotalPrice());
        order.setStatus(0);
        User  user = (User) session.getAttribute("user");
        order.setUid(user.getUid());

        ArrayList<OrderItem> orderItems = new ArrayList<>();
        for (ChartItem item: chart.getChartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setRed(item.getRed());
            orderItem.setBlue(item.getBlue());
            orderItem.setCount(item.getCount());
            orderItem.setOid(order.getId());
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);

        //save order
        mOrderService.save(order);

        //跳转
        return "redirect:/order/orderUI?oid="+order.getId();

    }

    @RequestMapping("/orderUI")
    public String showOrderUI(String oid, Model model){
        Order order = mOrderService.find(oid);
        model.addAttribute("order",order);
        return "generate_order";
    }


    @RequestMapping("/userOrderUI")
    public String showUserOrderUI(Model model,HttpSession session){
        User  user = (User) session.getAttribute("user");
        List<Order> orders = mOrderService.findByUid(user.getUid());
        System.out.println("showUserOrderUI:"+orders.size());
        model.addAttribute("orders",orders);
        return "order_list";
    }



}
