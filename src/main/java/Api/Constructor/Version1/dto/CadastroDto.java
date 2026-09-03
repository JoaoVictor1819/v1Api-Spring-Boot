package Api.Constructor.Version1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroDto(

        @NotBlank(message = "Name is mandatory")
        @Size(min = 4, max = 50, message = "Name must be between 4 and 50 characters")
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(max = 200, message = "Description must be")
        String descripition) {
}



/*
IMPORTANTE: Validacao de dados de entrada,
para garantir que os dados recebidos
pelo sistema
estejam corretos e consistentes.
*/