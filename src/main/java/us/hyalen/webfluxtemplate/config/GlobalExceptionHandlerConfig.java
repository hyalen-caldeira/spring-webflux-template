package us.hyalen.webfluxtemplate.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import us.hyalen.webfluxtemplate.core.BadGatewayException;
import us.hyalen.webfluxtemplate.core.dto.ErrorDto;
import us.hyalen.webfluxtemplate.core.dto.ResponseDto;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
/*
The @ControllerAdvice annotation was first introduced in Spring 3.2. It allows you to handle exceptions across
the whole application, not just to an individual controller. You can think of it as an interceptor of exceptions
thrown by methods annotated with @RequestMapping, for example.
*/
public class GlobalExceptionHandlerConfig {
    private final ErrorCodeConfig errorCodeConfig;

//    @ResponseBody
//    @ExceptionHandler(ClientException.class)
//    public ResponseEntity<ResponseDto<Void>> clientException(ClientException e) {
//        return new ResponseEntity<>(ResponseDto.forError(e.getErrorDtos()), e.getHttpStatus());
//    }

    @ResponseBody
    @ExceptionHandler(BadGatewayException.class)
    public ResponseEntity<ResponseDto<Void>> badGatewayException(BadGatewayException e) {
        ErrorDto errorDto =
                new ErrorDto(
                        errorCodeConfig.getBadGatewayCode(),
                        errorCodeConfig.getBadGatewayMessage(),
                        e.getMessage()
                );

        return new ResponseEntity<>(
                ResponseDto.forError(errorDto),
                HttpStatus.valueOf(errorCodeConfig.getBadGatewayHttp())
        );
    }
}
