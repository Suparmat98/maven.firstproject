package maven.firstproject.data.serialization;

public class SerializationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SerializationException(String message) {
        super(message);
    }
}