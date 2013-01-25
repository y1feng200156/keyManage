package com.keymanage.filter;

import com.keymanage.utils.CertificateUtils;
import com.keymanage.validata.ValidataKey;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URLDecoder;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 13-1-25 Time: 下午1:02 To change this template use File |
 * Settings | File Templates.
 */
public class ValidataFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        new ValidataKey().Validata();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    }

    @Override
    public void destroy() {
    }
}
