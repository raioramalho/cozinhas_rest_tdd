package br.com.raio.cozinhas.modules.person;

import br.com.raio.cozinhas.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    private PersonRepositorieTest repositorie;

    @Autowired
    private PersonService personService = new PersonService(repositorie);

    @Test
    void findAll() {
        List<Person> personList = this.personService.findAll();
        assertEquals(1, personList.size());
    }

    @Test
    void findById() {
        Optional<Person> person = this.personService.findById(1);
        assertEquals("Ramalho", person.get().getLastName());
    }

    @Test
    void findByEmail() {
        Optional<Person> person = this.personService.findByEmail("ramalho.sit@gmail.com");
        assertEquals("Ramalho", person.get().getLastName());
    }
}