package br.com.raio.cozinhas.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonTest {
    @Test
    void deve_criar_uma_pessoa() {
        Person alan = new Person();
        alan.setName("Alan");
        alan.setLastName("Ramalho");
        alan.setEmail("ramalho.sit@gmail.com");

        assert(alan.getName()).equals("Alan");
        assert(alan.getLastName()).equals("Ramalho");

    }

    @Test
    void deve_criar_uma_pessoa_a_partir_de_outra() {
        Person person = new Person("Alan", "Ramalho", "ramalho.sit@gmail.com");
        Person alan = new Person(person);

        assert(alan.getEmail()).equals("ramalho.sit@gmail.com");
    }
}
