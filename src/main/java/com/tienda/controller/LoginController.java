/**
 * @author KEREN NICOLE JIMENEZ FERNANDEZ
 */
package com.tienda.controller;
import com.tienda.service.PersonaService;
import com.tienda.entity.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    
    @GetMapping({"/"})
    public String index(){
        return "login";
    }
    
    
}
        
