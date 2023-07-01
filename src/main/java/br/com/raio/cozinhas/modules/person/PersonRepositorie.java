package br.com.raio.cozinhas.modules.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.raio.cozinhas.domain.Person;

@Repository
public interface PersonRepositorie extends JpaRepository<Person, Integer> {

}
