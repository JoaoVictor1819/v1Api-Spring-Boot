package Api.Constructor.Version1.handler;


import Api.Constructor.Version1.dto.ErrorDto;
import Api.Constructor.Version1.exception.CadastroNotFounException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandle extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CadastroNotFounException.class)
    private ResponseEntity<RestErroMenssage> cadastroNotFound(CadastroNotFounException ex){
        RestErroMenssage restErroMenssage = new RestErroMenssage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErroMenssage);
    }


    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<RestErroMenssage> cadastroException(RuntimeException ex){
        RestErroMenssage restErroMenssage = new RestErroMenssage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restErroMenssage);
    }


}
