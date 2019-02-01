/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.WebNotes.controller;

import com.pa.WebNotes.model.Nota;
import com.pa.WebNotes.service.NotaService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Giovanni
 */
@Controller
public class WebNotesController {
    @Autowired
    private NotaService notaService;
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public  ModelAndView Home()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Home");
        List<Nota> listanote = notaService.getAll();
        mav.addObject("listanote",listanote);
         mav.addObject("nota",new Nota());
        return mav;
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public  ModelAndView Add(@Valid Nota nota, BindingResult bindingresult)
    {
        ModelAndView mav = new ModelAndView();
        notaService.saveNota(nota);
        mav.setViewName("Home");
        List<Nota> listanote = notaService.getAll();
        mav.addObject("listanote",listanote);
        return mav;
    }
    @RequestMapping(value = "/edit/{notaId}",method = RequestMethod.GET)
    public  ModelAndView Update(@PathVariable Integer notaId)
    {
        ModelAndView mav = new ModelAndView();
       // notaService.findById(notaId
        mav.addObject("nota",notaService.findById(notaId));
        mav.setViewName("Edit_nota");
        return mav;
    }
    
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public  ModelAndView Update(@Valid Nota nota, BindingResult bindingresult)
    {
        ModelAndView mav = new ModelAndView();
        notaService.updateNota(nota);
        return new ModelAndView("redirect:/");
      
       
    }
    @RequestMapping(value = "/delete/{notaId}",method = RequestMethod.GET)
    public  ModelAndView Delete(@PathVariable Integer notaId)
    {
       // System.out.println("entrato " + notaId);
        ModelAndView mav = new ModelAndView();
       Optional<Nota>  N =  notaService.findById(notaId);
        mav.addObject("nota",N.get());
        mav.setViewName("delete_nota");
        return mav;
     
    }
    @RequestMapping(value = "/confirm/{notaId}",method = RequestMethod.POST)
    public  ModelAndView Confirm(@PathVariable Integer notaId)
    {
        ModelAndView mav = new ModelAndView();
        notaService.deleteNota(notaId);
        return new ModelAndView("redirect:/");
        
    }

}
