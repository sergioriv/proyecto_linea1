/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_linea1.help;

import com.mycompany.proyecto_linea1.entities.User;
import java.io.IOException;
import java.util.logging.LogRecord;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class FiltroSeguridad implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String Url = req.getRequestURL().toString();
        if (User.isAdmin() != null) {
            if (Url.contains("admin") && User.isAdmin() == "Admin") {
                chain.doFilter(request, response);
            } else if (Url.contains("comprador") && User.isAdmin() == "Comprador") {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect("../401.xhtml");
            }
        } else {
            res.sendRedirect("../index.xhtml");
        }
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
