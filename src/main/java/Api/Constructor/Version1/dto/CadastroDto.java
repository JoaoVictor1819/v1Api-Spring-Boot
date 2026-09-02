package Api.Constructor.Version1.dto;

public record CadastroDto(

        String name,

        String email,

        String descripiton) {
}



/*
IMPORTANTE: Validacao de dados de entrada,
para garantir que os dados recebidos
pelo sistema
estejam corretos e consistentes.
*/