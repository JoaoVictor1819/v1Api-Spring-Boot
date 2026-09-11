package Api.Constructor.Version1.Controller;


import Api.Constructor.Version1.database.model.Cargo;
import Api.Constructor.Version1.dto.CargoDto;
import Api.Constructor.Version1.service.CargoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/function/Cargo")
@Tag(name = "Cargo", description = "API para gerenciamento de Cargos")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping("/create")
    public ResponseEntity<Cargo> create(@RequestBody @Valid CargoDto dto){
        var cargo = cargoService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cargo);
    }

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        List<Cargo> cargos = cargoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cargos);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Cargo> findById(@PathVariable Long id){
        var cargo = cargoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cargo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        cargoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete Cargo succes");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cargo> update(@PathVariable Long id, @RequestBody @Valid CargoDto dto){
        var upadateCargo = cargoService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(upadateCargo);
    }

}
