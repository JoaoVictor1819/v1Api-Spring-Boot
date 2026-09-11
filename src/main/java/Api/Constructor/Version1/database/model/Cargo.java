package Api.Constructor.Version1.database.model;


import Api.Constructor.Version1.dto.CargoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Cargos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCargo;

    private BigDecimal salarioCargo;

    private String descricaoCargo;



    public Cargo(CargoDto dto){
        this.nomeCargo = dto.nomeCargo();
        this.salarioCargo = dto.salarioCargo();
        this.descricaoCargo = dto.descricaoCargo();
    }
}


