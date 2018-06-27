package com.czc.service.impl;

import com.czc.bean.Note;
import com.czc.dao.NoteDao;
import com.czc.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:NoteServiceImpl
 * Description:
 */
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao mNoteDao;

    @Override
    public Note save(Note note) {
        return mNoteDao.save(note);
    }

    @Override
    public Iterable<Note> findAll() {
        return mNoteDao.findAll();
    }

    @Override
    public Note findOne(String nid) {
        return mNoteDao.findOne(nid);
    }

    @Override
    public Note findNewestNote() {
        return mNoteDao.findTopByOrderByTimeDesc();
    }
}
