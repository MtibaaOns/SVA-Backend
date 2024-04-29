package EDS.SVA.exception;

public class DepotNotFoundException extends RuntimeException {
    public DepotNotFoundException(String message) {
        super(message);
    }
}