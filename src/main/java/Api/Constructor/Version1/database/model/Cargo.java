package Api.Constructor.Version1.database.model;


import Api.Constructor.Version1.dto.CargoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
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


    private String descricaoCargo;


    @OneToOne(mappedBy = "salario_id",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Salario salario;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cadastro> cadastro = new ArrayList<>();

    public Cargo(CargoDto dto){
        this.nomeCargo = dto.nomeCargo();
        this.descricaoCargo = dto.descricaoCargo();
    }
}


