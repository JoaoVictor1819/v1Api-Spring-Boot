package Api.Constructor.Version1.service;


import Api.Constructor.Version1.database.model.Cadastro;
import Api.Constructor.Version1.database.repository.CadatroRepository;
import Api.Constructor.Version1.exception.CadastroNotFounException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService {


    CadatroRepository cadatroRepository;

    public CadastroService(CadatroRepository cadatroRepository) {
        this.cadatroRepository = cadatroRepository;
    }


    public Cadastro save(){
       return cadatroRepository.save(new Cadastro());
    }


    public List<Cadastro> findAll(){
        return cadatroRepository.findAll();
    }

    public void delete(Long id){
        if (!cadatroRepository.existsById(id)){
            throw new CadastroNotFounException("Cadastro with id " + id + " not found");
        }
        cadatroRepository.deleteById(id);
    }
}
