/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.WebNotes.service;

import com.pa.WebNotes.model.Nota;
import com.pa.WebNotes.repository.NoteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Giovanni
 */
@Service("notaService")
public class NotaServiceImplem  implements NotaService{
    
    @Autowired
    private NoteRepository noterepository;

    @Override
    public void saveNota(Nota nota) {
        noterepository.save(nota);
       
    }

    @Override
    public List<Nota> getAll() {
        return noterepository.findAll();
       
    }

    /**
     *
     * @param notaId
     * @return
     */
    @Override
    public  Optional<Nota> findById(Integer notaId) {
        return noterepository.findById(notaId);
       
    }

    @Override
    public void updateNota(Nota n) {
         noterepository.save(n);
    }

    @Override
    public void deleteNota(Integer id) {
       
        noterepository.deleteById(id);
    }

 
    
}
