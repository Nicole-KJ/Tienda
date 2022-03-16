/**
 * @author KEREN NICOLE JIMENEZ FERNANDEZ
 */
package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping("/")
    public String index(){
        return "login";
    }
  
   /* 
   @GetMapping("/crear")
    public String crear(){
        return "redirect:/personasN";
    }
    */
}
        
