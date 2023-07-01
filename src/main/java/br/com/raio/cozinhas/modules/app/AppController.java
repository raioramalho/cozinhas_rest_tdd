package br.com.raio.cozinhas.modules.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {

    @GetMapping()
    public String helloWorld() {
        return "HelloWorld";
    }
}
