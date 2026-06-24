package com.hotusa.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.apache.logging.log4j.ThreadContext;

import java.io.IOException;
import java.util.UUID;

@WebFilter(urlPatterns = "/*", filterName = "LogFilter")
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Generar un ID único por petición
        String requestId = UUID.randomUUID().toString();

        // Ponerlo en el contexto de Log4j2
        ThreadContext.put("requestId", requestId);

        try {
            chain.doFilter(request, response);
        } finally {
            // Limpiar al terminar para evitar fugas de memoria
            ThreadContext.clearAll();
        }
    }
}