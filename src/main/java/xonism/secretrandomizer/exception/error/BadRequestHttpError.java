package xonism.secretrandomizer.exception.error;

import org.springframework.http.HttpStatus;

public class BadRequestHttpError extends HttpError {

    public BadRequestHttpError(String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }
}
