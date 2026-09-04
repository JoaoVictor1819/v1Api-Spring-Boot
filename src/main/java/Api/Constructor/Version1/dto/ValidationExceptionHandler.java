package Api.Constructor.Version1.dto;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDto exceptionHandler(MethodArgumentNotValidException ex){
        System.out.println("ENTROU NO VALIDATION EXCEPTION HANDLER");
        Map<String, String> Dtoerrors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName =  error.getField();
            String errorMessage = error.getDefaultMessage();
            Dtoerrors.put(fieldName, errorMessage);
        });
        return new ErrorDto(Dtoerrors);
    }
}
