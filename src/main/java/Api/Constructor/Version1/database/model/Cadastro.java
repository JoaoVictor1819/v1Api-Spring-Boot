package Api.Constructor.Version1.database.model;


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

    @Column(name = "Time_Registration")
    private LocalDateTime dataRegistro = LocalDateTime.now();

    @Column(name = "User", unique = false, updatable = true)
    private String name;

    @Column(name = "Email_User", unique = true, updatable = false)
    private String email;

    @Column(name = "Descripition_User")
    private String descripition;

}
