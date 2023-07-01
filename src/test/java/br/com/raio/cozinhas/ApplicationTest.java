package br.com.raio.cozinhas;

import br.com.raio.cozinhas.modules.app.AppController;
import org.junit.jupiter.api.Test;

class ApplicationTest {

    @Test
    void hello_world() {
        AppController appController = new AppController();
        String response = appController.helloWorld();

        assert(response).equals("HelloWorld");
    }
}