package Api.Constructor.Version1.database.repository;

import Api.Constructor.Version1.database.model.Cadastro;
import Api.Constructor.Version1.dto.CadastroDto;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.BIG_DECIMAL;


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
        var dto = new CadastroDto("Victor","victor@email.com",document,new BigDecimal(1000) , "Hello World!");
        this.createUser(dto);

        Optional<Cadastro> result = this.cadastroRepository.findCadastroByDocument(document);

        assertThat(result.isPresent()).isTrue();
    }


    @Test
    @DisplayName("Should not get register from DB when register not exists")
    void findCadastroByDocument2() {
        String document = "1111111112";

        Optional<Cadastro> result = this.cadastroRepository.findCadastroByDocument(document);

        assertThat(result.isEmpty());
    }


    private Cadastro createUser(CadastroDto dto){
        Cadastro newRegister = new Cadastro(dto);
        this.entityManager.persist(newRegister);
        return newRegister;
    }
}