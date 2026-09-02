package Api.Constructor.Version1.Controller;


import Api.Constructor.Version1.database.model.Cadastro;
import Api.Constructor.Version1.service.CadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/cadastro")
public class CadastroController {


    CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping("/save")
    public ResponseEntity<Cadastro> save(@RequestBody @Valid Cadastro dto){
      var cadastro = new Cadastro();
        BeanUtils.copyProperties(dto, cadastro);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroService.save(cadastro));
    }

    @GetMapping("/findAll")
    private ResponseEntity<List<Cadastro>> findAll(){
        List<Cadastro> cadastros = cadastroService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cadastros);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity delete(@PathVariable Long id){
        cadastroService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Sucessfully deleted");
    }
}
