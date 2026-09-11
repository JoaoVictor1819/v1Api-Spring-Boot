package Api.Constructor.Version1.dto;

import java.math.BigDecimal;

public record CargoDto(

        String nomeCargo,

        BigDecimal salarioCargo,

        String descricaoCargo)
{
}
