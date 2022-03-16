/**
 * @author KEREN NICOLE JIMENEZ FERNANDEZ
 */
package com.tienda.controller;

import com.tienda.entity.Persona;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonasController {
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping("/personas")
    public String index(Model model){
        List<Persona> listaPersonas=personaService.getAllPerson();
        model.addAttribute("titulo","Personas");
        model.addAttribute("personas",listaPersonas);
        return "personas";
    }
    
    @GetMapping("/personasN")
    public String crearPersona(Model model){
        model.addAttribute("persona", new Persona());
        return "crear";
    }
    
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona){
        personaService.savePerson(persona);
        return "redirect:/personas";
    }
    
    @GetMapping("/delete/{id}")
    public String modificarPersona(@PathVariable("id") Long idPersona){
        personaService.delete(idPersona);
        return "redirect:/personas";
    }
    
}
