package daw.icm.dontfwthese.controller;

import daw.icm.dontfwthese.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
// Cuando accedamos a esta URL, accederemos a este controlador.http://127.0.0.1:8080/info
    @GetMapping("/greeting")
    public String userGreeting(@RequestParam(required = false) String name1, String name2, Model model) { // Nombre del controlador
        model.addAttribute("message", "¡Bienvenido!"); // Envíamos un Stringmessage a la plantilla
        User userObject1 = new User(name1, name1+"@example.com"); // Accedemos al        modelo para crear un objeto
        User userObject2 = new User(name2, name2+"@example.com"); // Accedemos al        modelo para crear un objeto
        model.addAttribute("userObject1", userObject1); // Envíamos un objeto a la        plantilla
        model.addAttribute("userObject2", userObject2); // Envíamos un objeto a la        plantilla

        return "user-greeting"; // Plantilla que utilizará este controlador
    }
    @GetMapping("/helloworld")
    public String greeting(@RequestParam(required = false) String username, Model
            model) {
        model.addAttribute("message", "Hola " + username);
        return "helloworld";
    }
}