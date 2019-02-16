package api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class studentException extends RuntimeException {

    public studentException(String message) {
        super(message);
    }
}