package com.czc.controller;

import com.alibaba.fastjson.JSONArray;
import com.czc.bean.Chart;
import com.czc.bean.ChartItem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * ClassName:ChartController
 * Description:
 */
@Controller
@RequestMapping("/chart")
public class ChartController {

    @RequestMapping("selectUI")
    public String showSelectBallsUI(String randomFlag,Model model){
        if (randomFlag!=null){
            model.addAttribute("randomFlag","true");
        }
        return "select_ball";
    }

    @RequestMapping("select")
    @ResponseBody
    public String addSelectBalls(String items,HttpSession session){
        System.out.println("items:"+items);
        List<ChartItem> chartItems = JSONArray.parseArray(items, ChartItem.class);
        Chart chart = (Chart) session.getAttribute("chart");
        if(chart==null){
            chart=new Chart();
        }

//        Map<String, ChartItem> map = chart.getItems();
//        for (ChartItem item : chartItems) {
//            System.out.println("item:"+item);
//            String key = item.getRed() + "-" + item.getBlue();
//            if(map.containsKey(key)){
//                ChartItem chartItem = map.get(key);
//                chartItem.setCount(chartItem.getCount()+1);
//            }else{
//                item.setCount(1);
//                map.put(key,item);
//            }
//        }

        for (ChartItem item : chartItems) {
            chart.addChartItem(item);
        }

        session.setAttribute("chart",chart);

        //1.
//        HashMap<String, Integer> sendMap = new HashMap<>();
//        sendMap.put("cartSize",map.size());
//        return sendMap;

        //2.
        return "{\"cartSize\":\""+chart.getChartItems().size()+"\"}";
    }


    @RequestMapping("chartUI")
    public String showChartUI(HttpSession session){
        Chart chart = (Chart) session.getAttribute("chart");
        if(chart==null){
            chart=new Chart();
        }
        session.setAttribute("chart",chart);
        return "cart";
    }

    @RequestMapping("clearChart")
    public String clearChart(HttpSession session){
        Chart chart = (Chart) session.getAttribute("chart");
        if(chart==null){
            chart=new Chart();
        }
        chart.clearAll();
        return "redirect:/chart/chartUI";
    }

    @RequestMapping("delete")
    public String delete(String key,HttpSession session){
        Chart chart = (Chart) session.getAttribute("chart");
        if(chart==null){
            chart=new Chart();
        }
        chart.deleteOne(key);
        return "redirect:/chart/chartUI";
    }

}
