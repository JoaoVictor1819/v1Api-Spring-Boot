package Api.Constructor.Version1.database.repository;

import Api.Constructor.Version1.database.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
