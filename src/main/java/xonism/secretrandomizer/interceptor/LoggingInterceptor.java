package xonism.secretrandomizer.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Instant;

@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    /*
     * REQUEST|timestamp|method|uri|params
     * REQUEST|2025-11-15T10:02:45.225731Z|POST|/api/v1/secret-santa|null
     */
    @Override
    public boolean preHandle(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object handler
    ) {
        log.info(
                "REQUEST|{}|{}|{}|{}",
                Instant.now(),
                httpServletRequest.getMethod(),
                httpServletRequest.getRequestURI(),
                httpServletRequest.getQueryString()
        );
        return true;
    }

    /*
     * RESPONSE|timestamp|method|uri|params|statusCode
     * RESPONSE|2025-11-15T10:02:45.548065700Z|POST|/api/v1/secret-santa|null|200
     */
    @Override
    public void afterCompletion(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object handler,
            @Nullable Exception exception
    ) {
        log.info(
                "RESPONSE|{}|{}|{}|{}|{}",
                Instant.now(),
                httpServletRequest.getMethod(),
                httpServletRequest.getRequestURI(),
                httpServletRequest.getQueryString(),
                httpServletResponse.getStatus()
        );
    }
}
