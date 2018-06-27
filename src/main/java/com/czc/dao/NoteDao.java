package com.czc.dao;

import com.czc.bean.Note;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName:NoteDao
 * Description:
 */
public interface NoteDao extends JpaRepository<Note,String> {
    Note findTopByOrderByTimeDesc();
}
