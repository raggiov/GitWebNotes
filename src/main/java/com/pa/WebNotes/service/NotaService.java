/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.WebNotes.service;

import com.pa.WebNotes.model.Nota;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Giovanni
 */
public interface NotaService {
    public void saveNota(Nota nota);
    public List<Nota> getAll();
    public void updateNota(Nota n);

    public Optional<Nota> findById(Integer notaId);
    public void deleteNota(Integer id);
    
}
