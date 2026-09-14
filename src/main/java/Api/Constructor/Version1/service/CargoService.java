package Api.Constructor.Version1.service;


import Api.Constructor.Version1.database.model.Cargo;
import Api.Constructor.Version1.database.repository.CargoRepository;
import Api.Constructor.Version1.dto.CargoDto;
import Api.Constructor.Version1.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    private CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public Cargo save(CargoDto dto){
        var cargo = new Cargo(dto);
        return  cargoRepository.save(cargo);
    }

    public List<Cargo> findAll(){
        return cargoRepository.findAll();
    }

    public Cargo findById(Long id){
        return cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The position with the ID " +id+ " does not exist."));
    }

    public void delete(Long id){
        if (!cargoRepository.existsById(id) || cargoRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("The position with the ID " +id+ " does not exist.");
        }
        cargoRepository.deleteById(id);
    }


    public Cargo update(Long id, CargoDto dto){
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The position with the ID " +id+ " does not exist."));

        cargo.setNomeCargo(dto.nomeCargo());
        cargo.setSalarioCargo(dto.salarioCargo());
        cargo.setDescricaoCargo(dto.descricaoCargo());

        return cargoRepository.save(cargo);
    }

}
