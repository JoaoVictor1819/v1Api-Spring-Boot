package Api.Constructor.Version1.database.model;


import Api.Constructor.Version1.dto.CadastroDto;
import Api.Constructor.Version1.dto.CargoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

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

    @OneToMany(mappedBy = "cargo")
    private List<Cadastro> cadastro;

    public Cargo(CargoDto dto){
        this.nomeCargo = dto.nomeCargo();
        this.salarioCargo = dto.salarioCargo();
        this.descricaoCargo = dto.descricaoCargo();
    }
}


