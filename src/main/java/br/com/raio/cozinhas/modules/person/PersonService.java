package br.com.raio.cozinhas.modules.person;

import br.com.raio.cozinhas.domain.Person;
import br.com.raio.cozinhas.modules.app.helpers.ErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

  @Autowired
  private JpaRepository repositorie;

  public PersonService(JpaRepository repositorie) {
    this.repositorie = repositorie;
  }

  public Person save(Person person) {
    try {
      List<Person> all = this.repositorie.findAll();


      Optional<Person> findPerson = all.stream().filter(index -> index.getEmail().equals(person.getEmail())).findFirst();

      if(!findPerson.isEmpty()) {
        throw new ErrorHandler("Person is alredy registered.", HttpStatus.CONFLICT);
      }

      Person savePerson = (Person) this.repositorie.save(person);

      return savePerson;

    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

  public List<Person> findAll() {
    try {
      List<Person> all = this.repositorie.findAll();

      if (all.size() <= 0) {
        throw new ErrorHandler("Person not found.", HttpStatus.NOT_FOUND);
      }

      return all;

    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

  public Optional<Person> findById(Integer id) {
    try {
      Optional<Person> person = this.repositorie.findById(id);

      if (person.isEmpty()) {
        throw new ErrorHandler("Person not found.", HttpStatus.NOT_FOUND);
      }

      return person;

    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

  public Optional<Person> findByEmail(String email) {
    try {
      List<Person> all = this.repositorie.findAll();

      if (all.size() <= 0) {
        throw new ErrorHandler("Person not found.", HttpStatus.NOT_FOUND);
      }

      Optional<Person> person = all.stream().filter(index -> index.getEmail().equals(email)).findFirst();

      if (person.isEmpty()) {
        throw new ErrorHandler("Person not found.", HttpStatus.NOT_FOUND);
      }

      return person;

    } catch (Exception e) {
      throw new Error(e.getMessage());
    }
  }

}
