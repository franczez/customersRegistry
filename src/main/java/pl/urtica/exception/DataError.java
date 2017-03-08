package pl.urtica.exception;

/**
 * Created by Kamil on 2017-03-08.
 */
public class DataError extends RuntimeException {
    public DataError(String message) {
        super(message);
    }
}
