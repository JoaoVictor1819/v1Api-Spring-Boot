package Api.Constructor.Version1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record CadastroDto(

        @Size(min = 4, max = 50, message = "Name must be between 4 and 50 characters")
        @NotBlank(message = "Name is mandatory")
        String name,

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email should be valid")
        String email,

        @Size(max = 200, message = "The description cannot exceed 200 characters.")
        @NotBlank(message = "Description is mandatory")
        String descripition) {

}

/*
Validacoes impostantes para BRASIL:
@Cpf
@Cnpj
@TituloEleitoral
IMPORTANTE: Validacao de dados de entrada,
para garantir que os dados recebidos
pelo sistema
estejam corretos e consistentes.
*/