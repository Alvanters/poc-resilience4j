package nl.alvant.resilience4j.controller;

import nl.alvant.resilience4j.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resilience")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/retry-A")
    public String retryA() {
        separator();
        return demoService.retryA();
    }

    @GetMapping("/retry-B")
    public String retryB() {
        separator();
        return demoService.retryB();
    }

    @GetMapping("/retry-C")
    public String retryC() {
        separator();
        return demoService.retryC();
    }

    @GetMapping("/retry-D/{success}")
    public String retryD(@PathVariable("success") int success) {
        separator();
        return demoService.retryD(success);
    }

    private void separator() {
        System.out.println("----------");
    }
}