package Api.Constructor.Version1.exception;

public class CargoNotFoundException extends RuntimeException{

    public CargoNotFoundException() {
        super("Cargo Not Found");
    }

    public CargoNotFoundException(String message) {
        super(message);
    }
}
