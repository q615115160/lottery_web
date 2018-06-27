package com.czc.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * ClassName:Chart
 * Description:
 */
@Data
public class Chart {

    private double totalPrice;


    private Map<String, ChartItem> items = new HashMap<>();


    public Collection<ChartItem> getChartItems() {
        return items.values();
    }

    //add
    public void addChartItem(ChartItem item) {
        System.out.println("addChartItem:" + item);
        String key = item.getRed() + "-" + item.getBlue();
        if (items.containsKey(key)) {
            ChartItem chartItem = items.get(key);
            chartItem.setCount(chartItem.getCount() + 1);
        } else {
            item.setCount(1);
            items.put(key, item);
        }
    }


    //deleteone

    //clear
    public void clearAll(){
        items.clear();
    }
    
    public double getTotalPrice(){
        double totalPrice=0;
        for (String key : items.keySet()) {
            ChartItem chartItem = items.get(key);
            totalPrice+=chartItem.getSubTotal();
        }
        return totalPrice;
    }


    public void deleteOne(String key) {
        items.remove(key);
    }
}
