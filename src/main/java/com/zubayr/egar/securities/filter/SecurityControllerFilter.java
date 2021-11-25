package com.zubayr.egar.securities.filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.*;
import java.io.IOException;

public class SecurityControllerFilter implements Filter{

    Logger logger = LoggerFactory.getLogger(SecurityControllerFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean result = true;
        String price = servletRequest.getParameter("price");
        for (String s : price.split("")){
            if (!s.matches("[0-9]")) {
                result = false;
                logger.info("Данные некорректны, price= {}", price);
                break;
            }
        }
        if (result){
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }
}
