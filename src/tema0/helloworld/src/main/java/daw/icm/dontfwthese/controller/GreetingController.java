package daw.icm.dontfwthese.controller;

import daw.icm.dontfwthese.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class GreetingController {
// Cuando accedamos a esta URL, accederemos a este controlador.http://127.0.0.1:8080/info
    @GetMapping("/greeting")
    public String userGreeting(Model model) { // Nombre del controlador
        model.addAttribute("message", "¡Bienvenido!"); // Envíamos un Stringmessage a la plantilla
        User userObject = new User("David", "david@example.com"); // Accedemos al        modelo para crear un objeto
        model.addAttribute("userObject", userObject); // Envíamos un objeto a la        plantilla
        return "user-greeting"; // Plantilla que utilizará este controlador
    }
}