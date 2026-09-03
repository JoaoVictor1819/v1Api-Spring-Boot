package Api.Constructor.Version1.service;


import Api.Constructor.Version1.database.model.Cadastro;
import Api.Constructor.Version1.database.repository.CadatroRepository;
import Api.Constructor.Version1.dto.CadastroDto;
import Api.Constructor.Version1.exception.CadastroNotFounException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CadastroService {


    CadatroRepository cadatroRepository;

    public CadastroService(CadatroRepository cadatroRepository) {
        this.cadatroRepository = cadatroRepository;
    }


    public Cadastro save(Cadastro cadastro){
       return cadatroRepository.save(cadastro);
    }


    public List<Cadastro> findAll(){
        return cadatroRepository.findAll();
    }

    public Cadastro findById(Long id){
        return cadatroRepository.findById(id)
                .orElseThrow(()-> new CadastroNotFounException("Cadastro with id " + id + " not found"));
    }

    public void delete(Long id){
        if (!cadatroRepository.existsById(id)){
            throw new CadastroNotFounException("Cadastro with id " + id + " not found");
        }
        cadatroRepository.deleteById(id);
    }

    @Transactional
    public Cadastro update(Long id, CadastroDto dto){
        Cadastro cadastro = cadatroRepository.findById(id)
                .orElseThrow(()-> new CadastroNotFounException("Cadastro with id " + id + " not found"));

        cadastro.setName(dto.name());
        cadastro.setEmail(dto.email());
        cadastro.setDescripition(dto.descripition());

        return cadatroRepository.save(cadastro);
    }
}
