package com.czc.controller;

import com.czc.bean.BallHistory;
import com.czc.bean.Note;
import com.czc.service.HistoryService;
import com.czc.service.NoteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:IndexController
 * Description:
 */
@Controller("/")
class IndexController {


    @Autowired
    private HistoryService mHistoryService;

    @Autowired
    private NoteService mNoteService;


    @RequestMapping("/")
    public String index(Model model) {

        List<BallHistory> mHistoryList = mHistoryService.findAll();
        model.addAttribute("historyList", mHistoryList);

        Note note =mNoteService.findNewestNote();
        if (note != null) {
            model.addAttribute("lastbbs", note.getTitle());
        }
        //        System.out.println("index   historyList.size:" + historyList.size());
        Logger log = LoggerFactory.getLogger(IndexController.class);
//        log.error("index   historyList.size:" + historyList.size());
        log.error("index   historyList.size:{}", mHistoryList.size());
        return "index";


    }

    @RequestMapping("/detail")
    public String toLotteryDetail(String code, Model model) {
        System.out.println("detail:" + code);
        BallHistory history = mHistoryService.findOne(code);
        model.addAttribute("history", history);
        ArrayList<Object> objects = new ArrayList<>();
        return "lottery_detail";

    }



}
