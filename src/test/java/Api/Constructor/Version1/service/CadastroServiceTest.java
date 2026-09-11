package Api.Constructor.Version1.service;

import Api.Constructor.Version1.database.model.Cadastro;
import Api.Constructor.Version1.database.repository.CadastroRepository;
import Api.Constructor.Version1.dto.CadastroDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class CadastroServiceTest {

    @Mock
    private CadastroRepository cadastroRepository;


    @InjectMocks
    private CadastroService cadastroService;

    @Captor
    private ArgumentCaptor<Cadastro> cadastroArgumentCaptorCaptor;

    @Captor
    private ArgumentCaptor<Long>  LongArgumentCaptor;

    @Nested
    class CadastroSave{

        @Test
        @DisplayName("Should creat a user with success")
        void saveCase1(){

            // Arrange
            var cadastro = new Cadastro();
            doReturn(cadastro).when(cadastroRepository).save(cadastroArgumentCaptorCaptor.capture());

            var input = new CadastroDto("Victor",
                    "victor@email.com",
                    "11111111102",
                    new BigDecimal(1000),
                    "Hello World!");
            // Act
            var output = cadastroService.save(input);


            // Assert
            assertNotNull(output);
            var userCaptor = cadastroArgumentCaptorCaptor.getValue();

            assertEquals(input.name(), userCaptor.getName());
            assertEquals(input.email(), userCaptor.getEmail());
            assertEquals(input.document(), userCaptor.getDocument());
        }


        @Test
        @DisplayName("should throw excepition when error occurs")
        void shouldThrowExceptionWhenErrorOccurs(){
            // Arrange

            doThrow(new RuntimeException()).when(cadastroRepository).save(any());

            var input = new CadastroDto("Victor",
                    "victor@email.com",
                    "11111111102",
                    new BigDecimal(1000),
                    "Hello World!");
            // Act
            assertThrows(RuntimeException.class, () ->  cadastroService.save(input));

        }
    }

    @Nested
    class findById{

        @Test
        @DisplayName("Should get cadastro by id with success when optional is present")
        void shouldGetCadastroByIdWithSuccessWhenOptionIsPresent() {

            // Arrange
            var cadastro = new Cadastro();
            cadastro.setId(1L);
            doReturn(Optional.of(cadastro)).when(cadastroRepository).findById(LongArgumentCaptor.capture());

            // Act

            var output = cadastroService.findById(cadastro.getId());

            // Assert
            assertTrue(cadastro.equals(output));
            assertEquals(cadastro.getId(), LongArgumentCaptor.getValue());
        }

    }
}