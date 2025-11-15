package xonism.secretrandomizer.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import xonism.secretrandomizer.util.RequestContext;

import java.time.Instant;

@Getter // needed for returning response
@RequiredArgsConstructor
public class HttpError {

    private final Instant timestamp = Instant.now();
    private final String path = RequestContext.getPath();
    private final int status;
    private final String message;
}
