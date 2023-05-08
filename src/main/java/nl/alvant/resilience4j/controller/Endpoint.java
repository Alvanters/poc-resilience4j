package nl.alvant.resilience4j.controller;

import nl.alvant.resilience4j.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Endpoint {

    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting justSayHello() {
        return new Greeting("Hi Guild");
    }
}
