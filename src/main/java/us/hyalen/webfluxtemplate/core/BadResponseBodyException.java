package us.hyalen.webfluxtemplate.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Any message here ...")
public class BadResponseBodyException extends RuntimeException {
    public BadResponseBodyException(String message) {
        super(message);
    }
}
