package com.czc.service;

import com.czc.bean.Note;

/**
 * ClassName:NoteService
 * Description:
 */
public interface NoteService {
    Note save(Note note);

    Iterable<Note> findAll();

    Note findOne(String nid);

    Note findNewestNote();
}
