package Api.Constructor.Version1.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestErroMenssage {
    private HttpStatus status;
    private String message;
}
