package Api.Constructor.Version1.Controller;


import Api.Constructor.Version1.database.model.Cadastro;
import Api.Constructor.Version1.dto.CadastroDto;
import Api.Constructor.Version1.service.CadastroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/cadastro")
@Tag(name = "Cadastro", description = "API para gerenciamento de cadastros")
public class CadastroController {


    CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping("/save")
    @Operation(summary = "Cadatrar usuário", description = "Endpoint para cadastrar um novo usuário que ainda nao esta cadastrado na base de dados")
    public ResponseEntity<Cadastro> save(@RequestBody @Valid Cadastro dto){
      var cadastro = new Cadastro();
        BeanUtils.copyProperties(dto, cadastro);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroService.save(cadastro));
    }

    @GetMapping("/findAll")
    @Operation(summary = "Lista todos os cadastros", description = "Endpoint para listar todos os cadastros que estao na base de dados")
    private ResponseEntity<List<Cadastro>> findAll(){
        List<Cadastro> cadastros = cadastroService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cadastros);
    }

    @GetMapping("/findById/{id}")
    @Operation(summary = "Busca cadastro por ID", description = "Endpoint para buscar um cadastro pelo seu ID na base de dados")
    private ResponseEntity<Cadastro> findById(@Valid @PathVariable Long id){
        Cadastro cadastro = cadastroService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cadastro);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deleta cadastro por ID", description = "Endpoint para deletar um cadastro pelo seu ID na base de dados")
    private ResponseEntity delete(@Valid @PathVariable Long id){
        cadastroService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Sucessfully deleted");
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Atualiza cadastro por ID", description = "Endpoint para atualizar um cadastro pelo seu ID na base de dados")
    private ResponseEntity<Cadastro> update(@Valid @PathVariable Long id, @RequestBody CadastroDto dto){
        Cadastro updateCadatro = cadastroService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updateCadatro);
    }
}
