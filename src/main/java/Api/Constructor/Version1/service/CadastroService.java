package Api.Constructor.Version1.service;


import Api.Constructor.Version1.database.model.Cadastro;
import Api.Constructor.Version1.database.repository.CadastroRepository;
import Api.Constructor.Version1.dto.CadastroDto;
import Api.Constructor.Version1.exception.CadastroNotFounException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CadastroService {


    private CadastroRepository cadastroRepository;

    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }


    public Cadastro save(Cadastro cadastro){
       return cadastroRepository.save(cadastro);
    }


    public List<Cadastro> findAll(){
        return cadastroRepository.findAll();
    }

    public Cadastro findById(Long id){
        return cadastroRepository.findById(id)
                .orElseThrow(()-> new CadastroNotFounException("Cadastro with id " + id + " not found"));
    }

    public List<Cadastro> findByName(String name){
        if (name == null || name.isEmpty()){
            return cadastroRepository.findAll();
        }
        return cadastroRepository.findByNameContainingIgnoreCase(name);
    }

    public Optional<Cadastro> findByDocument(String document){
        return Optional.of(cadastroRepository.findCadastroByDocument(document)
                .orElseThrow(() -> new CadastroNotFounException("Document: " + document + " not found")));
    }

    public void delete(Long id){
        if (!cadastroRepository.existsById(id)){
            throw new CadastroNotFounException("Cadastro with id " + id + " not found");
        }
        cadastroRepository.deleteById(id);
    }

    @Transactional
    public Cadastro update(Long id, CadastroDto dto){
        Cadastro cadastro = cadastroRepository.findById(id)
                .orElseThrow(()-> new CadastroNotFounException("Cadastro with id " + id + " not found"));

        cadastro.setName(dto.name());
        cadastro.setEmail(dto.email());
        cadastro.setDescripition(dto.descripition());

        return cadastroRepository.save(cadastro);
    }
}
