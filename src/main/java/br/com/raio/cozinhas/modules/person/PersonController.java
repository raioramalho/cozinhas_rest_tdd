package br.com.raio.cozinhas.modules.person;

import br.com.raio.cozinhas.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("person")
public class PersonController {

    private PersonRepositorie repositorie;

    @Autowired
    private PersonService personService = new PersonService(repositorie);

    @GetMapping()
    public List<Person> getAll() {
        List<Person> persons = this.personService.findAll();
        return persons;
    }

    @GetMapping(params = "id")
    public Optional<Person> getById(@RequestParam Integer id) {
        Optional<Person> person = this.personService.findById(id);
        return person;
    }

    @GetMapping(params = "email")
    public Optional<Person> getByEmail(@RequestParam String email) {
        Optional<Person> person = this.personService.findByEmail(email);
        return person;
    }

}
