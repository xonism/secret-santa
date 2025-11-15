package xonism.secretrandomizer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xonism.secretrandomizer.exception.error.BadRequestHttpError;
import xonism.secretrandomizer.exception.error.HttpError;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public HttpError handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("Invalid method argument", e);
        String message = e.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining("; "));
        return new BadRequestHttpError(message);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalStateException.class})
    public HttpError handleGenericBadRequest(Exception e) {
        log.error("Encountered bad request", e);
        return new BadRequestHttpError(e.getMessage());
    }
}
