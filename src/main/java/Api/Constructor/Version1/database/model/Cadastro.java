package Api.Constructor.Version1.database.model;


import Api.Constructor.Version1.dto.CadastroDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Table(name = "cadastros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDateTime dataRegistro = LocalDateTime.now();


    private String name;

    @Column(unique = true, updatable = false)
    private String email;

    @Column(unique = true)
    private String document;

    private String descripition;

    public Cadastro(CadastroDto dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.document = dto.document();
        this.descripition = dto.descripition();
    }
}
