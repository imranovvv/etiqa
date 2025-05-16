package com.demo.etiqa;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class ApiRequestResponseLoggingFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(ApiRequestResponseLoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        try {
            filterChain.doFilter(wrappedRequest, wrappedResponse);
        } finally {
            logRequest(wrappedRequest);
            logResponse(wrappedResponse);
            wrappedResponse.copyBodyToResponse(); // Important!
        }
    }

    private void logRequest(ContentCachingRequestWrapper request) {
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String body = getStringValue(request.getContentAsByteArray());

        logger.info("📥 REQUEST: {} {}{} \nBody: {}",
                method,
                uri,
                (queryString != null ? "?" + queryString : ""),
                body);

    }

    private void logResponse(ContentCachingResponseWrapper response) {
        int status = response.getStatus();
        String body = getStringValue(response.getContentAsByteArray());

        logger.info("📤 RESPONSE: HTTP {} \nBody: {}", status, body);
    }

    private String getStringValue(byte[] content) {
        if (content.length == 0) return "[empty]";
        return new String(content, StandardCharsets.UTF_8);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getRequestURI().startsWith("/api");
    }

}
