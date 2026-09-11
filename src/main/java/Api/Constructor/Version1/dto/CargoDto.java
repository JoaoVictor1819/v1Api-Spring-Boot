package Api.Constructor.Version1.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record CargoDto(


        @NotBlank(message = "Defining the type of position is mandatory.")
        String nomeCargo,


        @NotNull(message = "Specifying the salary amount is mandatory.")
        @PositiveOrZero(message = "Salary must be a positive number or zero")
        @DecimalMin(value = "0.1", message = "Salary must be a positive number or zero")
        BigDecimal salarioCargo,

        @NotBlank(message = "Provide the job specifications.")
        String descricaoCargo)
{
}
