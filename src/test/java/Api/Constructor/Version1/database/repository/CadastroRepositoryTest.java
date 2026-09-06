package Api.Constructor.Version1.database.repository;

import Api.Constructor.Version1.database.model.Cadastro;
import Api.Constructor.Version1.dto.CadastroDto;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
class CadastroRepositoryTest {

    @Autowired
    private CadastroRepository cadastroRepository;


    @Autowired
    EntityManager entityManager;


    @Test
    @DisplayName("Should get register successfully from DB")
    void findCadastroByDocument() {
        String document = "999939939939";
        var dto = new CadastroDto("Victor","victor@email.com",document, "dasdadsadadwdaw");
        this.createUser(dto);

        Optional<Cadastro> result = this.cadastroRepository.findCadastroByDocument(document);

        assertThat(result.isPresent()).isTrue();
    }


    private Cadastro createUser(CadastroDto dto){
        Cadastro newRegister = new Cadastro(dto);
        this.entityManager.persist(newRegister);
        return newRegister;
    }
}