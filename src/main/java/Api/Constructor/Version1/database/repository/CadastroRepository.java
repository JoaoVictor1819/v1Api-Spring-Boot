package Api.Constructor.Version1.database.repository;

import Api.Constructor.Version1.database.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    List<Cadastro> findByNameContainingIgnoreCase(String name);

    Optional<Cadastro> findCadastroByDocument(String document);

    List<Cadastro> findByName(String name);
}
