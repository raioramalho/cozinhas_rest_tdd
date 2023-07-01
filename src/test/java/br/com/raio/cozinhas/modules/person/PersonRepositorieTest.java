package br.com.raio.cozinhas.modules.person;

import br.com.raio.cozinhas.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepositorieTest extends JpaRepository<Person, Integer> {
}
