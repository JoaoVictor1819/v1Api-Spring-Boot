package Api.Constructor.Version1.exception;

public class CadastroNotFounException extends RuntimeException {

    public CadastroNotFounException() {
        super("Cadastro not found");
    }

    public CadastroNotFounException(String message) {
        super(message);
    }
}
