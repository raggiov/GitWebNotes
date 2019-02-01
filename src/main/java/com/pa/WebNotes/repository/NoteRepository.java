/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.WebNotes.repository;

import com.pa.WebNotes.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Giovanni
 */
@Repository("noteRepository")
public interface NoteRepository extends  JpaRepository<Nota, Integer>{
    
}
