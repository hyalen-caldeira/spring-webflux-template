package us.hyalen.webfluxtemplate.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// You can also use @ResponseStatus to annotate a custom exception class with a status code and reason that is applied to the HTTP response.
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Any message here ...")
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}