/**
 * @author KEREN NICOLE JIMENEZ FERNANDEZ
 */
package com.tienda.controller;

import com.tienda.entity.Persona;
import com.tienda.service.IPersonaService;
import com.tienda.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonasController {
    @Autowired
    private IPersonaService personaService;
    @GetMapping("/personas")
    public String index(Model model){
        List<Persona> listaPersonas=personaService.getAllPerson();
        System.out.println(listaPersonas);
        model.addAttribute("titulo","Personas");
        model.addAttribute("personas",listaPersonas);
        return "personas";
    }
    
    @GetMapping("/nuevaPersona")
    public String nuevaPersona(Persona persona){
        return "modificarPersona";
    }
    
/**
 * Arreglar errores
 */
    @PostMapping("/guardarPersona")
    public String guardarPersona(Persona persona){
        IPersonaService.savePerson(persona);
        PersonaService.savePerson(persona);
        return "redirect:/";
    }
    
    @GetMapping("/modificarPersona/{idPersona}")
    public String modificarCliente(Persona persona, Model model){
        persona = IPersonaService.getPersonById();
        model.addAttribute("persona", persona);
        return "modificarPersona";
    }
}
