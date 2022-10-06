package com.teamStocker.global.security.jwt.filter;

import com.teamStocker.global.error.ErrorResponse;
import com.teamStocker.global.error.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtExceptionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(req, res); // go to 'JwtAuthenticationFilter'
        } catch (BusinessException e) {
            setErrorResponse(res, e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setErrorResponse(HttpServletResponse res, BusinessException e) throws IOException {
        res.setStatus(HttpStatus.UNAUTHORIZED.value());
        res.setContentType("application/json; charset=UTF-8");

        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(e.getErrorCode().getStatus())
                .message(e.getMessage())
                .build();

        res.getWriter().write(errorResponse.convertToJson());
    }
}
