package Api.Constructor.Version1.handler;



import Api.Constructor.Version1.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandle {


    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<RestErroMenssage> resourceNotFound(ResourceNotFoundException ex){
        RestErroMenssage restErroMenssage = new RestErroMenssage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErroMenssage);
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<RestErroMenssage> globalExceptionHandler(RuntimeException ex){
        RestErroMenssage restErroMenssage = new RestErroMenssage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restErroMenssage);
    }

   @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<RestErroMenssage> cadastroMenssageException(HttpMessageNotReadableException ex){
        RestErroMenssage restErroMenssage = new RestErroMenssage(HttpStatus.BAD_REQUEST, "Invalid request body");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restErroMenssage);
    }




}
