package xonism.secretrandomizer.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestContext {

    public static String getPath() {
        HttpServletRequest httpServletRequest = getRequest();
        return httpServletRequest != null
                ? httpServletRequest.getRequestURI()
                : null;
    }

    private static HttpServletRequest getRequest() {
        return RequestContextHolder.getRequestAttributes() != null
                ? ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest()
                : null;
    }
}
