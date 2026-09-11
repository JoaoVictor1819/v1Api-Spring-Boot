package Api.Constructor.Version1.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CargoDto(

        @Size(min = 5, message = "Invalid position")
        @NotBlank(message = "Defining the type of position is mandatory.")
        String nomeCargo,


        @NotNull(message = "Specifying the salary amount is mandatory.")
        @PositiveOrZero(message = "Salary must be a positive number or zero")
        @DecimalMin(value = "0.1", message = "Salary must be a positive number or zero")
        BigDecimal salarioCargo,

        @Size(max = 200, message = "Do not exceed the maximum character limit.")
        @NotBlank(message = "Provide the job specifications.")
        String descricaoCargo)
{
}
