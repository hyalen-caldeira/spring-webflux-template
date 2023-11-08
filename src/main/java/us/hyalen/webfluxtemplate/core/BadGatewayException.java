package us.hyalen.webfluxtemplate.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// The exception is being treated by GlobalExceptionHandler. You don't need the annotation @ResponseStatus here.
// @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Any message here ...")
public class BadGatewayException extends RuntimeException {
    public BadGatewayException(String message) {
        super(message);
    }
}
