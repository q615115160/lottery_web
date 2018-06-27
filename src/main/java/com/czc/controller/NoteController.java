package com.czc.controller;

import com.czc.bean.Note;
import com.czc.bean.User;
import com.czc.service.NoteService;
import com.czc.utils.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ClassName:NoteController
 * Description:
 */
@Controller
@RequestMapping("/bbs")
public class NoteController {

    @Autowired
    private NoteService mNoteService;


    @RequestMapping("/bbs_index")
    public String bbsIndexUI(Model model){

        Iterable<Note> notes=mNoteService.findAll();
        model.addAttribute("notes",notes);
        return "bbs_index";
    }

    @RequestMapping("/publish")
    public String publish(Note note, HttpServletRequest request, HttpSession session) {
        note.setNid(UUIDUtils.getCode());
        note.setIpaddress(request.getRemoteAddr());
        note.setTime(new Date().toLocaleString());
        User user = (User) session.getAttribute("user");
        note.setUsername(user.getUsername());

        Note savedNote = mNoteService.save(note);
        return "redirect:/bbs/bbs_index";
    }


    @RequestMapping("/detail")
    public String getNoteDetail(String nid,Model model){
        Note note=mNoteService.findOne(nid);
        model.addAttribute("note",note);
        return "bbs_detail";
    }
}
